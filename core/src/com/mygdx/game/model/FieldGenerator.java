package com.mygdx.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.geom.Point2D;

public class FieldGenerator {

    ModelManager modelManager;
    Position firstFieldPosition;

    List<SafeField> fields;

    int minimalDistanceBetweenFields;

    public FieldGenerator(ModelManager modelManager, Position firstFieldPosition) {
        this.modelManager = modelManager;
        this.firstFieldPosition = firstFieldPosition;
    }

    public List<SafeField> generateFields(int numberOfSafeFields,
                                          int minimalDistanceBetweenFields) {
        this.minimalDistanceBetweenFields = minimalDistanceBetweenFields;
        fields = new ArrayList<>();

        fields.add(new SafeField(firstFieldPosition));

        for(int i = 1; i <= 5; ++i) {
            Position position = new Position(firstFieldPosition.x + i * 600, firstFieldPosition.y);
            fields.add(new SafeField(position));
        }


        long currentTime = System.currentTimeMillis();
        Random generator = new Random(currentTime);
        int x,y;

        for (int i = 0; i < numberOfSafeFields; i++) {
            x  = (generator.nextInt()%(modelManager.getBackground().getWidth()/2))
                    +modelManager.lavaGame.width;
            y  = (generator.nextInt()%(modelManager.getBackground().getHeight()/2))
                    +modelManager.lavaGame.height;

            if (x <= 0) {
                x += (int)fields.get(0).width*2;
            } else {
                x -= (int)fields.get(0).width*2;
            }

            if (y <= 0) {
                y += (int)fields.get(0).height*2;
            } else {
                y -= (int)fields.get(0).height*2;
            }

            SafeField fieldCandidate = new SafeField(new Position(x, y));
            if(validateField(fieldCandidate)){
                fields.add(fieldCandidate);
            } else {
                --i;
            }
        }
        return fields;
    }

    private boolean validateField(SafeField candidateField) {

        for(SafeField addedField : fields) {
            if(!validateField(candidateField, addedField)) {
                return false;
            }
        }

        double distance = Point2D.distance(candidateField.x,
                candidateField.y,
                modelManager.getExitField().getX(),
                modelManager.getExitField().getY());

        if(distance < minimalDistanceBetweenFields) {
            return false;
        }

        return !(candidateField.y <= firstFieldPosition.y);
    }

    private boolean validateField(SafeField candidateField, SafeField addedField) {
        double distance = Point2D.distance(candidateField.x, candidateField.y, addedField.x, addedField.y);
        return !(distance < minimalDistanceBetweenFields);
    }

}
