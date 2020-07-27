package br.unicamp.mc322.pf.heroquest.input;

public interface Input {
	public Command waitForNextCommand();
	
	public int waitForOption(int expectedNumberOptions);
}
