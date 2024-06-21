package com.flcat.Dospital.service;

import com.flcat.Dospital.domain.follow.FollowRepository;
import com.flcat.Dospital.domain.pet.PetRepository;
import com.flcat.Dospital.domain.user.User;
import com.flcat.Dospital.domain.user.UserRepository;
import com.flcat.Dospital.web.dto.UserProfileResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final FollowRepository followRepository;
    private final PetRepository petRepository;

    @Value("${file.path}")
    private String uploadFolder;

    @Transactional(readOnly = true)
    public UserProfileResponseDto UserProfile(Long userId, Long principalId) throws IllegalAccessException {
        UserProfileResponseDto userProfileResponseDto = new UserProfileResponseDto();
        User userEntity = userRepository.findById(userId).orElseThrow(() -> {
                return new IllegalArgumentException();
            });

            int followState = followRepository.mFollowState(principalId, userId);
            int followCount = followRepository.mFollowCount(userId);
            int petCount = petRepository.mPetCount(userId);

            userProfileResponseDto.setFollowState(followState == 1);
            userProfileResponseDto.setFollowCount(followCount);
            userProfileResponseDto.setPetCount(petCount);

            userProfileResponseDto.setUser(userEntity);

        return userProfileResponseDto;
    }

    @Transactional
    public User UpdateProfile(Long id, User user) {

    }
}
