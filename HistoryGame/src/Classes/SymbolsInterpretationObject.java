package Classes;

import javafx.beans.property.SimpleStringProperty;

public class SymbolsInterpretationObject {

    private SimpleStringProperty symbols, briefInterpretation;

    public SymbolsInterpretationObject(String symbols, String briefInterpretation) {

        this.symbols = new SimpleStringProperty(symbols);
        this.briefInterpretation = new SimpleStringProperty(briefInterpretation);
    }

    //symbols
    public String getSymbols() {
        return symbols.get();
    }

    public void setSymbols(String symbols) {
        this.symbols = new SimpleStringProperty(symbols);
    }

    //briefInterpretation
    public String getBriefInterpretation() {
        return briefInterpretation.get();
    }

    public void setBriefInterpretation(String briefInterpretation) {
        this.briefInterpretation = new SimpleStringProperty(briefInterpretation);
    }





}
