package ir.maktab56.airline.repository;

import ir.maktab56.airline.base.repository.BaseRepository;
import ir.maktab56.airline.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {


    User existByUsername(String username);
}
