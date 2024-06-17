package com.themyntt.dStock.contracts;

public interface IUseCaseContract<I, O> {
    O run(I dto);
}
