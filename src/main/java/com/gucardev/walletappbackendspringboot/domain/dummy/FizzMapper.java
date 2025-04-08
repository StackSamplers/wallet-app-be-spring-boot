package com.gucardev.walletappbackendspringboot.domain.dummy;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FizzMapper {

    Fizz toEntity(FizzDto request);

    FizzDto toDto(Fizz entity);
}
