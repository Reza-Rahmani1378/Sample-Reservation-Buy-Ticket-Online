package ir.maktab56.airline.service;

import ir.maktab56.airline.base.service.BaseService;
import ir.maktab56.airline.domain.User;

public interface UserService extends BaseService<User, Long> {

    User login();

    void singUp();

}
