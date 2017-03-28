package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Group;

public interface GroupRepository extends JpaRepository <Group,Long> {

}
