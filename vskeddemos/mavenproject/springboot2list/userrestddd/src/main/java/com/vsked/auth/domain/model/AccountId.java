package com.vsked.auth.domain.model;

import com.vsked.domain.shared.ValueObject;
import org.apache.commons.lang3.Validate;

public class AccountId implements ValueObject<AccountId> {

    private Long id;

    public AccountId(Long id) {
        Validate.notNull(id);
        this.id = id;
    }

    public String idString(){
        return id.toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountId other = (AccountId) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean sameValueAs(AccountId other){
        return other!=null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return id.toString();
    }

    AccountId(){
    }
}
