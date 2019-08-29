package com.example.server.serivce;

import com.example.server.model.Student;
import com.example.server.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService implements StudentRepository {

    @Override
    public <S extends Student> S save(S s) {
        return null;
    }

    @Override
    public <S extends Student> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Iterable<Student> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void deleteAll(Iterable<? extends Student> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
