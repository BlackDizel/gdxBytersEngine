package org.byters.engine.model.dialog;

import java.util.ArrayList;

public class ModelDialogStep {
    private int id;
    private ArrayList<ModelPhraseNPC> npc_phrases;
    private ArrayList<ModelPhrasePlayer> answers;

    public int getId() {
        return id;
    }

    public ArrayList<ModelPhraseNPC> getNpc_phrases() {
        return npc_phrases;
    }

    public ArrayList<ModelPhrasePlayer> getAnswers() {
        return answers;
    }
}
