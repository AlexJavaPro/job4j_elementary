package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author ALEKSEY MAYOROV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами
     * реализовано с помощью HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *  Метод позволяет добавить пользователя в хранилище,
     *  если он не добавлен
     * @param user - пользователь который добавляется в хранилище
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод позволяет удалить пользователя по паспортным данным
     * @param passport - данные паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добаляет новый счёт по паспортным данным пользователя
     * @param passport - данные паспорта пользователя
     * @param account - счёт для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод позволяет получить пользователя по паспортным данным
     * @param passport - данные паспорта пользователя
     * @return возвращает пользователя или null, если его нет в хранилище
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод позволяет получить счёт по паспортным данным и реквизитам
     * @param passport - данные паспорта пользователя
     * @param requisite - реквизиты счёта
     * @return возвращает счёт или null, если его нет в хранилище
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
        List<Account> list = getAccounts(user);
            for (Account account : list) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод позволяет совершить платёж с баланса счёта первого пользователя на баланс счёта второго пользователя
     * по паспортным данным пользователей и реквизитам счетов
     * @param srcPassport - данные паспорта первого пользователя
     * @param srcRequisite - реквизиты счёта первого пользователя
     * @param destPassport - данные паспорта второго пользователя
     * @param destRequisite - реквизиты счёта второго  пользователя
     * @param amount - сумма транзакции
     * @return возвращает true, если платёж успешен
     * или false одного из счётов не существует
     * или недостаточно денежных средств на балансе счёта первого пользователя
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод позволяет найти список счётов пользователя
     * @param user пользователь
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}