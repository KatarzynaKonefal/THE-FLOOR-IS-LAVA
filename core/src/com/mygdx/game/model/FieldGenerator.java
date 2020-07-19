package com.mygdx.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.geom.Point2D;

public class FieldGenerator {

    ModelManager modelManager;
    Position firstFieldPosition;

    List<SafeField> fields;

    public FieldGenerator(ModelManager modelManager, Position firstFieldPosition) {
        this.modelManager = modelManager;
        this.firstFieldPosition = firstFieldPosition;
    }

    public List<SafeField> generateFields() {
        fields = new ArrayList<>();

        fields.add(new SafeField(firstFieldPosition));

        long currentTime = System.currentTimeMillis();
        Random generator = new Random(currentTime);
        int x;
        int y;
        for (int i = -1; i < modelManager.numberOfSafeFields - 1; i++) {
            x  = (generator.nextInt()%(modelManager.getBackground().getWidth()/2 - (int)fields.get(0).width))+((3*modelManager.lavaGame.width)/4);
            y  = (generator.nextInt()%(modelManager.getBackground().getHeight()/2 - (int)fields.get(0).height))+((3*modelManager.lavaGame.height)/4);

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

        if(distance < 400) {
            return false;
        }

        return !(candidateField.y <= firstFieldPosition.y);
    }

    private boolean validateField(SafeField candidateField, SafeField addedField) {
        double distance = Point2D.distance(candidateField.x, candidateField.y, addedField.x, addedField.y);
        return !(distance < 400);
    }

}
