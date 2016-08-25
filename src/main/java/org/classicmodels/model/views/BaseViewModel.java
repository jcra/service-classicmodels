package org.classicmodels.model.views;

import java.lang.reflect.Field;

public class BaseViewModel {

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Field f : this.getClass().getDeclaredFields()) {

            /** make private fields accessible */
            f.setAccessible(true);

            try {

                if (f.get(this) == null) {
                    sb.append(f.getName() + " : " + f.get(this) +"\n");
                }

            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }

        }

        return sb.toString();
    }
}
