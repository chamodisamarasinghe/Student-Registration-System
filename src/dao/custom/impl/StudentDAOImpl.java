package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entity) {
        return false;
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Student find(String s) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
