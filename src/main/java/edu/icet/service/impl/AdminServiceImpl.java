package edu.icet.service.impl;

import edu.icet.model.Admin;
import edu.icet.repository.AdminRepository;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;
    private final ModelMapper mapper;
    @Override
    public Admin searchAdminEmail(String email) {
        return mapper.map(repository.findByEmail(email),Admin.class);

    }
}
