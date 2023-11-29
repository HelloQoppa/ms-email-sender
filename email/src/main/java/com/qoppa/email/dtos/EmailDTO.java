package com.qoppa.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailDTO(
        @NotBlank String ownerRef,
        @NotBlank @Email String emailForm,
        @NotBlank @Email String emailTo,
        @NotBlank String subject,
        @NotBlank String text) {

}
