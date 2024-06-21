package com.flcat.Dospital.web.dto;

import com.flcat.Dospital.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponseDto {

    private User user;
    private boolean followState; //구독 여부
    private int followCount;
    private int petCount;


    //save 가 아니기 때문에 Entity 필요 없음.
}
