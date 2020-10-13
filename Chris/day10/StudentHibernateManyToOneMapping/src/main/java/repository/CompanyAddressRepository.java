package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.CompanyAddress;

@Repository
public interface CompanyAddressRepository extends JpaRepository<CompanyAddress,Long>
{

}
