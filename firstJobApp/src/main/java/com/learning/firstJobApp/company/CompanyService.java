package com.learning.firstJobApp.company;

import java.util.List;

public interface CompanyService {
	List<Company> getAllCompanies();
	void addCompany(Company company);
	Company getCompanyById(Long id);
	boolean deleteCompanyById(Long id);
	boolean updateCompany(Long id, Company updatedCompany);
}
