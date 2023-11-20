package com.sample.tokenization.repository;

import com.sample.tokenization.vault.Vault;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaultRepository extends CrudRepository<Vault, Long> {
}
