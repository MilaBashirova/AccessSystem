package ru.accesssystem.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accesssystem.model.User;
import ru.accesssystem.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bashirova Milyausha
 */
@Component
public class CheckDoorServiceImpl implements CheckDoorService {
    private static final Logger LOG = Logger.getLogger(CheckDoorServiceImpl.class.getName());

    @Autowired
    UsersRepository usersRepository;

    @Override
    public int getResultCheck(Integer roomId, Boolean entrance, Integer keyId, String token) {
        Optional<User> user = usersRepository.findByToken(token);
        if (user.isPresent()) {
            if (user.get().getId() % roomId == 0) {
                if (user.get().getEntrance()==false && entrance == true) {
                    user.get().setEntrance(true);
                    usersRepository.save(user.get());
                    LOG.info("Дверь можно открыть");

                    return 200;
                }
                if (user.get().getEntrance()==true && entrance == false) {
                    user.get().setEntrance(false);
                    usersRepository.save(user.get());
                    LOG.info("Дверь можно открыть");
                    return 200;
                }
            }
            LOG.warn("Запрет на вход");
            return 403;
        }
        LOG.error("Ошибка");
        return 500;
    }
}
