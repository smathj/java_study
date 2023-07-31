package com.java.study.practical.ch11;


public class Code {

    private String code;
    private String codeName;

    private String codeParents;
    private String codeParentsName;

    private int order;

    public Code() {
    }

    public Code(String code, String codeName, String codeParents, String codeParentsName, int order) {
        this.code = code;
        this.codeName = codeName;
        this.codeParents = codeParents;
        this.codeParentsName = codeParentsName;
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeParents() {
        return codeParents;
    }

    public void setCodeParents(String codeParents) {
        this.codeParents = codeParents;
    }

    public String getCodeParentsName() {
        return codeParentsName;
    }

    public void setCodeParentsName(String codeParentsName) {
        this.codeParentsName = codeParentsName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                ", codeName='" + codeName + '\'' +
                ", codeParents='" + codeParents + '\'' +
                ", codeParentsName='" + codeParentsName + '\'' +
                ", order=" + order +
                '}';
    }
}
