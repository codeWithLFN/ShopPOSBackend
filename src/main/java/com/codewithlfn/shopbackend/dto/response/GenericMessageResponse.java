package com.codewithlfn.shopbackend.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericMessageResponse {
    private String message;
}
