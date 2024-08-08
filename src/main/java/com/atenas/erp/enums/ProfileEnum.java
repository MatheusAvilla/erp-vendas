package com.atenas.erp.enums;

public enum ProfileEnum {
    ADMINISTRADOR, GERENTE, VENDEDOR;

    public static ProfileEnum fromName(String name) {
        if (name != null) {
            for (ProfileEnum profile : ProfileEnum.values()) {
                if (profile.name().equalsIgnoreCase(name)) {
                    return profile;
                }
            }
        }
        return null;
    }
}
