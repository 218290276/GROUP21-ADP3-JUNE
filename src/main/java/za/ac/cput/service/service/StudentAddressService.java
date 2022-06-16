package za.ac.cput.service.service;

import za.ac.cput.domain.StudentAddress;

import java.util.List;

public interface StudentAddressService extends IService<StudentAddress,StudentAddress.StudentAddressId> {
    List<StudentAddress> findAll();
    //void deleteById(String id);
    List<StudentAddress> findByStudentId(String studentId);
}
