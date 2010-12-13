package com.twoqubed.testing.user;

public interface UserRepository {

    User findUser(String userId) throws UserNotFoundException;

    void updateUser(User user);
}
