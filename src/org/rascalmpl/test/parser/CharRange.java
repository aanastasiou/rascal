package org.rascalmpl.test.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IValue;
import org.rascalmpl.parser.sgll.SGLL;
import org.rascalmpl.parser.sgll.stack.AbstractStackNode;
import org.rascalmpl.parser.sgll.stack.CharStackNode;
import org.rascalmpl.parser.sgll.stack.NonTerminalStackNode;
import org.rascalmpl.values.uptr.Factory;

/*
S ::= [a-z]
*/
public class CharRange extends SGLL implements IParserTest{
	private final static IConstructor SYMBOL_START_S = vf.constructor(Factory.Symbol_Sort, vf.string("S"));
	private final static IConstructor SYMBOL_char_a_z = vf.constructor(Factory.Symbol_CharClass, vf.list(vf.constructor(Factory.CharRange_Range, vf.integer(97), vf.integer(122))));
	
	private final static IConstructor PROD_PLUSLISTa_z_a_z = vf.constructor(Factory.Production_Default, vf.list(SYMBOL_char_a_z), SYMBOL_START_S, vf.constructor(Factory.Attributes_NoAttrs));
	
	private final static AbstractStackNode NONTERMINAL_START_S = new NonTerminalStackNode(START_SYMBOL_ID, "S");
	private final static AbstractStackNode CHAR_a0 = new CharStackNode(0, new char[][]{{'a','z'}});
	
	public CharRange(){
		super();
	}
	
	public void S(){
		expect(PROD_PLUSLISTa_z_a_z, CHAR_a0);
	}
	
	public IValue parse(IConstructor start, char[] input){
		throw new UnsupportedOperationException();
	}
	
	public IValue parse(IConstructor start, File inputFile) throws IOException{
		throw new UnsupportedOperationException();
	}
	
	public IValue parse(IConstructor start, InputStream in) throws IOException{
		throw new UnsupportedOperationException();
	}
	
	public IValue parse(IConstructor start, Reader in) throws IOException{
		throw new UnsupportedOperationException();
	}
	
	public IValue parse(IConstructor start, String input){
		throw new UnsupportedOperationException();
	}
	
	public boolean executeTest(){
		CharRange cr = new CharRange();
		IValue result = cr.parse(NONTERMINAL_START_S, "a".toCharArray());
		return result.equals("TODO");
	}

	public static void main(String[] args){
		CharRange cr = new CharRange();
		IValue result = cr.parse(NONTERMINAL_START_S, "a".toCharArray());
		System.out.println(result);
		
		System.out.println("S([a-z](a)) <- good");
	}
}
