package com.dashlexz.spring.pp_312.service;

import com.dashlexz.spring.pp_312.DAO.UserDao;
import com.dashlexz.spring.pp_312.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServicelmpl implements UserService {

    private UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(UserServicelmpl.class);
    @Autowired
    public UserServicelmpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        logger.info("Сохранение пользователя {}", user);
        if (user != null) {
            logger.info("Пользователь успешно сохранен: {}", user);
            userDao.saveUser(user);
        } else {
            logger.error("Невозможно сохранить пользователя: пользователь null");
            throw new IllegalArgumentException("Невозможно сохранить пользователя: пользователь null");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        logger.info("Получение списка пользователей");
        List<User> users = null;
        try {
            users = userDao.listUsers();
            logger.info("Пользователи успешно получены {}", userDao.listUsers());
        }catch (Exception e) {
            logger.error("Произошла ошибка при получении списка пользователей.", e);
        }
        logger.info("Получены пользователи{}", users != null ? users.size() : 0);
        return users;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        logger.info("Обновление пользователя: {}", user);
        if (user != null) {
            userDao.updateUser(user);
            logger.info("Пользователь обновлен: {}", user);
        } else {
            logger.error("Невозможно обновить пользователя: пользователь null");
            throw new IllegalArgumentException("Невозможно обновить пользователя: пользователь null");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        logger.info("Удаление пользователя с ID: {}", id);
        if (id != null) {
            userDao.deleteById(id);
            logger.info("Пользователь удален {}", id);
        } else {
            logger.error("Невозможно удалить пользователя: id null");
            throw new IllegalArgumentException("Невозможно удалить пользователя: id null");
        }
    }
    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        User user;
        logger.info("Получение пользователя с ID: {}", id);
        if (id != null) {
            user = userDao.getUser(id);
            logger.info("Пользователь получен {}", id);
        } else {
            logger.error("Невозможно получить пользователя: id null");
            throw new IllegalArgumentException("Невозможно получить пользователя: id null");
        }
        return user;
    }
}
