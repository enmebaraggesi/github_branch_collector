package com.github_branch_collector.service;

import com.github_branch_collector.domain.Owner;
import com.github_branch_collector.received.OwnerReceivedDto;
import org.springframework.stereotype.Service;

@Service
class OwnerMapper {
    
    static Owner mapOwnerReceivedDtoToOwner(OwnerReceivedDto receivedDto) {
        return new Owner(receivedDto.login());
    }
    
    static String mapOwnerToOwnerName(Owner owner) {
        return owner.login();
    }
}
