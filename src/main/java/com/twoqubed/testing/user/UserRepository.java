package com.twoqubed.testing.user;

public interface UserRepository {

    User findUser(String userId);

    void updateUser(User user);
}
