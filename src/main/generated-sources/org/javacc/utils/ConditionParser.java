/* ConditionParser.java */
/* Generated By:JavaCC: Do not edit this line. ConditionParser.java */
package org.javacc.utils;

import java.io.StringReader;
import java.util.Map;

public class ConditionParser implements ConditionParserConstants {
    private Map<String, Object> options;

    public static void main(String... args) throws ParseException
    {
      test("F", false);
      test("T", true);
      test("F || T", true);
      test("T || F", true);
      test("T || will not be compiled )", true);
      test("F && T", false);
      test("T && T", true);
      test("unknown", false);
    }

    private static void test(String input, boolean expectedValue)  throws ParseException
    {
      ConditionParser cp = new ConditionParser(new StringReader(input));
      Map<String,Object> values = new java.util.HashMap<String,Object>();
      values.put("F", Boolean.FALSE);
      values.put("T", Boolean.TRUE);
      boolean value = cp.CompilationUnit(values);
      System.out.println(input + " = " + value);
      if (value != expectedValue)
        throw new RuntimeException();
    }

  final public boolean CompilationUnit(Map<String,Object> options) throws ParseException {boolean value;
    this.options = options;
    value = ConditionalExpression();
{if ("" != null) return value;}
    throw new Error("Missing return statement in function");
}

  final public boolean ConditionalExpression() throws ParseException {boolean value;
    value = ConditionalAndExpression();
if (value) {if ("" != null) return true;}
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SC_OR:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(SC_OR);
      value = ConditionalAndExpression();
if (value) {if ("" != null) return true;}
    }
{if ("" != null) return false;}
    throw new Error("Missing return statement in function");
}

  final public boolean ConditionalAndExpression() throws ParseException {boolean value;
    value = UnaryExpressionNotPlusMinus();
if (!value) {if ("" != null) return false;}
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SC_AND:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      jj_consume_token(SC_AND);
      value = UnaryExpressionNotPlusMinus();
if (!value) {if ("" != null) return false;}
    }
{if ("" != null) return true;}
    throw new Error("Missing return statement in function");
}

  final public boolean UnaryExpressionNotPlusMinus() throws ParseException {boolean value;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BANG:
    case 18:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 18:{
        jj_consume_token(18);
        break;
        }
      case BANG:{
        jj_consume_token(BANG);
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      value = UnaryExpressionNotPlusMinus();
{if ("" != null) return !value;}
      break;
      }
    case LPAREN:
    case TRUE:
    case FALSE:
    case IDENTIFIER:{
      value = UnaryExpression();
{if ("" != null) return value;}
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public boolean UnaryExpression() throws ParseException {boolean value;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TRUE:
    case FALSE:{
      value = Literal();
{if ("" != null) return value;}
      break;
      }
    case LPAREN:{
      jj_consume_token(LPAREN);
      value = ConditionalExpression();
      jj_consume_token(RPAREN);
{if ("" != null) return value;}
      break;
      }
    case IDENTIFIER:{
      value = Name();
{if ("" != null) return value;}
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public boolean Literal() throws ParseException {boolean value;
    value = BooleanLiteral();
{if ("" != null) return value;}
    throw new Error("Missing return statement in function");
}

  final public boolean BooleanLiteral() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TRUE:{
      jj_consume_token(TRUE);
{if ("" != null) return true;}
      break;
      }
    case FALSE:{
      jj_consume_token(FALSE);
{if ("" != null) return false;}
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public boolean Name() throws ParseException {String name;
    jj_consume_token(IDENTIFIER);
name = getToken(0).image.trim();

            Object obj = options.get(name);

            if (obj instanceof Boolean)
            {
              {if ("" != null) return ((Boolean)obj).booleanValue();}
            }
            else if (obj instanceof String)
            {
              String string = ((String)obj).trim();
              {if ("" != null) return string.length() > 0 && !string.equalsIgnoreCase("false") && !string.equalsIgnoreCase("no");}
            }

            {if ("" != null) return false;}
    throw new Error("Missing return statement in function");
}

  /** Generated Token Manager. */
  public ConditionParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x10000,0x20000,0x48000,0x3ca000,0x382000,0x180000,};
	}

  /** Constructor with InputStream. */
  public ConditionParser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ConditionParser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ConditionParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ConditionParser(java.io.Reader stream) {
	 jj_input_stream = new JavaCharStream(stream, 1, 1);
	 token_source = new ConditionParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new JavaCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ConditionParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ConditionParser(ConditionParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ConditionParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[24];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 6; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 24; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private int trace_indent = 0;
  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
