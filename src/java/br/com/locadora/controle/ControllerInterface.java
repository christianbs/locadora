package br.com.locadora.controle;

import javax.servlet.http.HttpServletRequest;

public interface ControllerInterface {
    enum ReturnType {FORWARD, REDIRECT}
    public void init(HttpServletRequest request);
    public void execute();
    public String getReturnPage();
    public ReturnType getReturnType();
}
