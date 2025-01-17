package com.learning.firstJobApp.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learning.firstJobApp.company.Company;
import com.learning.firstJobApp.company.CompanyRepository;
import com.learning.firstJobApp.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public void addCompany(Company company) {
		companyRepository.save(company);
	}
	
	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
		
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;

	}

	@Override
	public boolean updateCompany(Long id, Company updatedCompany) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company company = companyOptional.get();
			company.setName(updatedCompany.getName());
			company.setDescription(updatedCompany.getDescription());
			company.setJobs(updatedCompany.getJobs());
			companyRepository.save(company);
			return true;
		}
		return false;
	}


}
