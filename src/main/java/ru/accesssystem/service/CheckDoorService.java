package ru.accesssystem.service;


/**
 * @author Bashirova Milyausha
 */

public interface CheckDoorService {
     int getResultCheck(Integer roomId, Boolean entrance, Integer keyId, String token);
}
