/* The following code was generated by JFlex 1.4.1 on 8/22/15 12:29 PM */

/*
 * 09/03/2005
 *
 * CSSTokenMaker.java - Token maker for CSS 3 files.
 * 
 * This library is distributed under a modified BSD license.  See the included
 * RSyntaxTextArea.License.txt file for details.
 */
package org.fife.ui.rsyntaxtextarea.modes;

import java.io.*;
import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.*;


/**
 * This class splits up text into tokens representing a CSS 3 file.  It's
 * written with a few extra internal states so that it can easily be copy
 * and pasted into HTML, PHP, and JSP TokenMakres when it is updated.<p>
 *
 * This implementation was created using
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1; however, the generated file
 * was modified for performance.  Memory allocation needs to be almost
 * completely removed to be competitive with the handwritten lexers (subclasses
 * of <code>AbstractTokenMaker</code>, so this class has been modified so that
 * Strings are never allocated (via yytext()), and the scanner never has to
 * worry about refilling its buffer (needlessly copying chars around).
 * We can achieve this because RText always scans exactly 1 line of tokens at a
 * time, and hands the scanner this line as an array of characters (a Segment
 * really).  Since tokens contain pointers to char arrays instead of Strings
 * holding their contents, there is no need for allocating new memory for
 * Strings.<p>
 *
 * The actual algorithm generated for scanning has, of course, not been
 * modified.<p>
 *
 * If you wish to regenerate this file yourself, keep in mind the following:
 * <ul>
 *   <li>The generated <code>CSSTokenMaker.java</code> file will contain 2
 *       definitions of both <code>zzRefill</code> and <code>yyreset</code>.
 *       You should hand-delete the second of each definition (the ones
 *       generated by the lexer), as these generated methods modify the input
 *       buffer, which we'll never have to do.</li>
 *   <li>You should also change the declaration/definition of zzBuffer to NOT
 *       be initialized.  This is a needless memory allocation for us since we
 *       will be pointing the array somewhere else anyway.</li>
 *   <li>You should NOT call <code>yylex()</code> on the generated scanner
 *       directly; rather, you should use <code>getTokenList</code> as you would
 *       with any other <code>TokenMaker</code> instance.</li>
 * </ul>
 *
 * @author Robert Futrell
 * @version 0.5
 *
 */

public class CSSTokenMaker extends AbstractJFlexCTokenMaker {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** lexical states */
  public static final int CSS_C_STYLE_COMMENT = 5;
  public static final int YYINITIAL = 0;
  public static final int CSS_STRING = 3;
  public static final int CSS_VALUE = 2;
  public static final int CSS_PROPERTY = 1;
  public static final int CSS_CHAR_LITERAL = 4;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\41\1\62\25\0\1\41\1\63\1\56\1\37\1\53\1\46"+
    "\1\50\1\57\1\44\1\64\1\5\1\52\1\55\1\4\1\6\1\42"+
    "\12\1\1\7\1\40\1\0\1\52\1\61\1\50\1\35\6\47\24\2"+
    "\1\51\1\43\1\51\1\61\1\3\1\0\1\21\1\34\1\15\1\20"+
    "\1\26\1\23\1\33\1\14\1\16\1\2\1\30\1\17\1\27\1\13"+
    "\1\11\1\25\1\2\1\10\1\22\1\12\1\32\1\31\1\36\1\45"+
    "\1\24\1\2\1\54\1\61\1\60\1\52\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\3\0\1\2\1\3\2\4\1\5\2\2"+
    "\1\6\1\7\1\2\1\10\1\11\1\1\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\16\1\20\2\16\1\21"+
    "\1\22\1\23\1\24\1\25\2\1\2\24\1\26\1\1"+
    "\1\27\1\30\1\24\1\31\1\32\1\33\1\34\1\35"+
    "\1\32\1\36\1\37\5\32\1\40\2\0\1\3\3\0"+
    "\1\4\15\0\12\41\1\3\1\42\1\3\1\43\1\44"+
    "\2\0\1\25\3\0\1\25\1\0\1\33\1\45\27\0"+
    "\11\41\12\0\1\17\14\0\11\41\3\0\1\46\14\0"+
    "\5\41\1\47\2\41\13\0\6\41\5\0\3\41\4\0"+
    "\2\41\3\0\1\41\4\0\1\50";

  private static int [] zzUnpackAction() {
    int [] result = new int[230];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\152\0\237\0\324\0\u0109\0\u013e\0\u0173"+
    "\0\u01a8\0\u01dd\0\u0212\0\u0247\0\u027c\0\u013e\0\u02b1\0\u02e6"+
    "\0\u013e\0\u013e\0\u013e\0\u013e\0\u013e\0\u013e\0\u013e\0\u013e"+
    "\0\u031b\0\u0350\0\u013e\0\u0385\0\u02e6\0\u013e\0\u013e\0\u013e"+
    "\0\u013e\0\u03ba\0\u03ef\0\u0424\0\u0385\0\u0459\0\u013e\0\u048e"+
    "\0\u013e\0\u013e\0\u04c3\0\u013e\0\u04f8\0\u052d\0\u013e\0\u013e"+
    "\0\u0562\0\u013e\0\u013e\0\u0597\0\u05cc\0\u0601\0\u0636\0\u066b"+
    "\0\u013e\0\u06a0\0\u06d5\0\u013e\0\u070a\0\u073f\0\u0774\0\u07a9"+
    "\0\u07de\0\u0813\0\u0848\0\u087d\0\u08b2\0\u08e7\0\u091c\0\u0951"+
    "\0\u0986\0\u09bb\0\u09f0\0\u0a25\0\u0a5a\0\u0a8f\0\u0ac4\0\u0af9"+
    "\0\u0b2e\0\u0b63\0\u0b98\0\u0bcd\0\u0c02\0\u0c37\0\u0c6c\0\u0ca1"+
    "\0\u0cd6\0\u0d0b\0\u013e\0\u0d40\0\u0d75\0\u0daa\0\u013e\0\u0ddf"+
    "\0\u0e14\0\u0e49\0\u0459\0\u0e7e\0\u013e\0\u013e\0\u0eb3\0\u0ee8"+
    "\0\u0f1d\0\u0f52\0\u0f87\0\u0fbc\0\u0ff1\0\u1026\0\u105b\0\u1090"+
    "\0\u10c5\0\u10fa\0\u112f\0\u1164\0\u1199\0\u11ce\0\u1203\0\u1238"+
    "\0\u126d\0\u12a2\0\u12d7\0\u130c\0\u1341\0\u1376\0\u13ab\0\u13e0"+
    "\0\u1415\0\u144a\0\u147f\0\u14b4\0\u14e9\0\u151e\0\u1553\0\u1588"+
    "\0\u15bd\0\u15f2\0\u1627\0\u165c\0\u1691\0\u16c6\0\u16fb\0\u1730"+
    "\0\u013e\0\u1765\0\u179a\0\u17cf\0\u1804\0\u1839\0\u186e\0\u18a3"+
    "\0\u18d8\0\u190d\0\u1942\0\u1977\0\u19ac\0\u19e1\0\u1a16\0\u1a4b"+
    "\0\u1a80\0\u1ab5\0\u1aea\0\u1b1f\0\u1b54\0\u1b89\0\u1bbe\0\u1bf3"+
    "\0\u1c28\0\u1c5d\0\u1c92\0\u1cc7\0\u1cfc\0\u1d31\0\u1d66\0\u1d9b"+
    "\0\u1dd0\0\u1e05\0\u1e3a\0\u1e6f\0\u1ea4\0\u1ed9\0\u1f0e\0\u1f43"+
    "\0\u1f78\0\u1fad\0\u1fe2\0\u0a8f\0\u2017\0\u204c\0\u2081\0\u20b6"+
    "\0\u1c5d\0\u20eb\0\u2120\0\u2155\0\u218a\0\u21bf\0\u21f4\0\u2229"+
    "\0\u225e\0\u2293\0\u22c8\0\u22fd\0\u2332\0\u2367\0\u239c\0\u23d1"+
    "\0\u2406\0\u243b\0\u2470\0\u24a5\0\u24da\0\u250f\0\u2544\0\u2579"+
    "\0\u25ae\0\u25e3\0\u2618\0\u264d\0\u2682\0\u26b7\0\u26ec\0\u2721"+
    "\0\u2756\0\u278b\0\u27c0\0\u27f5\0\u282a\0\u013e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[230];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\7\1\10\2\11\1\12\2\11\1\13\25\11\1\14"+
    "\1\11\1\15\1\16\1\17\1\20\1\7\1\16\1\11"+
    "\1\7\1\11\1\7\1\16\2\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\21\1\27\1\7\1\16\2\30\3\31"+
    "\1\32\1\30\1\33\25\31\1\34\1\31\2\30\1\17"+
    "\1\35\2\30\1\31\1\30\1\31\4\30\1\36\3\30"+
    "\1\37\1\30\1\40\2\30\1\41\1\42\2\43\1\44"+
    "\1\41\1\23\1\41\25\43\1\45\1\43\1\46\1\47"+
    "\1\17\1\50\1\43\1\51\1\43\1\41\1\43\5\41"+
    "\1\23\1\24\1\25\1\37\1\41\1\52\1\53\1\54"+
    "\43\55\1\56\12\55\1\57\3\55\1\60\2\55\43\61"+
    "\1\56\13\61\1\62\2\61\1\63\2\61\5\64\1\65"+
    "\6\64\1\66\6\64\1\67\12\64\1\70\23\64\1\71"+
    "\2\64\66\0\1\10\4\0\1\10\6\0\1\72\1\73"+
    "\3\0\1\74\2\0\1\75\1\76\1\77\16\0\1\74"+
    "\17\0\4\11\1\0\1\11\1\0\25\11\1\0\1\11"+
    "\6\0\1\11\1\0\1\11\16\0\1\100\3\11\1\0"+
    "\1\11\1\0\25\11\1\0\1\11\6\0\1\11\1\0"+
    "\1\11\24\0\1\101\1\102\1\103\1\104\1\105\1\106"+
    "\1\107\1\0\1\110\1\111\1\112\1\0\1\113\2\0"+
    "\1\114\2\0\1\115\35\0\3\116\3\0\3\116\1\117"+
    "\1\116\1\120\1\121\1\116\1\122\2\116\1\123\1\116"+
    "\1\124\1\116\1\125\1\126\1\127\3\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\1\130\5\131\1\0"+
    "\5\131\1\132\2\131\2\132\1\131\1\132\2\131\1\132"+
    "\5\131\1\132\1\0\1\131\6\0\1\131\1\0\1\132"+
    "\56\0\1\17\30\0\1\133\60\0\4\31\3\0\25\31"+
    "\1\0\1\31\6\0\1\31\1\0\1\31\17\0\3\31"+
    "\3\0\25\31\1\0\1\31\6\0\1\31\1\0\1\31"+
    "\17\0\3\134\3\0\25\134\1\0\1\134\6\0\1\134"+
    "\1\0\1\134\16\0\1\42\4\0\1\42\6\0\1\135"+
    "\1\136\3\0\1\137\2\0\1\140\1\141\1\142\16\0"+
    "\1\137\20\0\3\43\3\0\25\43\1\0\1\43\3\0"+
    "\2\43\1\51\1\43\1\0\1\43\16\0\1\42\3\43"+
    "\3\0\25\43\1\0\1\43\3\0\2\43\1\51\1\43"+
    "\1\0\1\43\16\0\1\143\13\0\1\143\2\0\2\143"+
    "\1\0\1\143\2\0\1\143\5\0\1\143\12\0\1\143"+
    "\17\0\3\43\1\133\2\0\25\43\1\0\1\43\3\0"+
    "\2\43\1\51\1\43\1\0\1\43\33\0\1\144\46\0"+
    "\43\55\1\0\12\55\1\0\3\55\1\0\2\55\62\145"+
    "\1\0\2\145\43\61\1\0\13\61\1\0\2\61\1\0"+
    "\2\61\5\64\1\0\6\64\1\0\6\64\1\0\12\64"+
    "\1\0\23\64\1\0\2\64\42\0\1\146\34\0\1\147"+
    "\64\0\1\150\3\0\1\151\104\0\1\152\55\0\1\74"+
    "\50\0\1\74\63\0\1\74\2\0\1\74\27\0\1\74"+
    "\46\0\1\74\15\0\1\74\41\0\1\74\4\0\1\74"+
    "\36\0\1\100\3\11\1\0\1\100\1\0\25\11\1\0"+
    "\1\11\6\0\1\11\1\74\1\11\36\0\1\153\1\0"+
    "\1\154\10\0\1\155\41\0\1\156\66\0\1\157\72\0"+
    "\1\160\54\0\1\161\1\162\63\0\1\163\67\0\1\164"+
    "\66\0\1\165\2\0\1\166\61\0\1\167\63\0\1\170"+
    "\60\0\1\171\4\0\1\172\61\0\1\173\13\0\1\174"+
    "\53\0\1\175\47\0\4\116\1\0\1\116\1\0\25\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\11\116\1\176\13\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\4\116\1\177\20\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\16\0\4\116\1\0\1\116\1\0\17\116"+
    "\1\200\5\116\1\0\1\116\6\0\1\116\1\0\1\116"+
    "\16\0\4\116\1\0\1\116\1\0\1\116\1\201\23\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\1\116\1\202\23\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\11\116\1\203\13\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\16\0\4\116\1\0\1\116\1\0\16\116"+
    "\1\204\6\116\1\0\1\116\6\0\1\116\1\0\1\116"+
    "\16\0\4\116\1\0\1\116\1\0\16\116\1\205\6\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\6\116\1\206\16\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\1\130\13\0\1\130"+
    "\2\0\2\130\1\0\1\130\2\0\1\130\5\0\1\130"+
    "\12\0\1\130\16\0\4\131\1\0\1\131\1\0\25\131"+
    "\1\0\1\131\6\0\1\131\1\0\1\131\16\0\1\132"+
    "\3\131\1\0\1\131\1\0\5\131\1\132\2\131\2\132"+
    "\1\131\1\132\2\131\1\132\5\131\1\132\1\0\1\131"+
    "\6\0\1\131\1\0\1\132\16\0\4\134\1\0\1\134"+
    "\1\0\25\134\1\0\1\134\6\0\1\134\1\0\1\134"+
    "\44\0\1\137\50\0\1\137\63\0\1\137\2\0\1\137"+
    "\27\0\1\137\46\0\1\137\15\0\1\137\41\0\1\137"+
    "\4\0\1\137\64\0\1\207\47\0\1\210\77\0\1\211"+
    "\56\0\1\212\103\0\1\213\51\0\1\214\57\0\1\215"+
    "\74\0\1\216\47\0\1\161\72\0\1\217\55\0\1\220"+
    "\66\0\1\221\66\0\1\222\101\0\1\223\61\0\1\224"+
    "\51\0\1\225\64\0\1\226\6\0\1\227\64\0\1\173"+
    "\54\0\1\230\67\0\1\231\57\0\1\232\75\0\1\233"+
    "\70\0\1\234\61\0\1\235\43\0\4\116\1\0\1\116"+
    "\1\0\17\116\1\236\5\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\16\0\4\116\1\0\1\116\1\0\11\116"+
    "\1\237\13\116\1\0\1\116\6\0\1\116\1\0\1\116"+
    "\16\0\4\116\1\0\1\116\1\0\15\116\1\240\7\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\5\116\1\241\17\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\3\116\1\242\21\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\16\0\4\116\1\0\1\116\1\0\23\116"+
    "\1\243\1\116\1\0\1\116\6\0\1\116\1\0\1\116"+
    "\16\0\4\116\1\0\1\116\1\0\10\116\1\244\14\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\14\116\1\245\10\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\16\116\1\246\6\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\42\0\1\247\64\0\1\250\46\0\1\251"+
    "\103\0\1\211\44\0\1\252\70\0\1\223\62\0\1\253"+
    "\77\0\1\254\65\0\1\255\73\0\1\256\35\0\1\257"+
    "\106\0\1\260\53\0\1\261\77\0\1\221\67\0\1\221"+
    "\43\0\1\255\70\0\1\262\100\0\1\263\54\0\1\227"+
    "\76\0\1\264\42\0\1\265\70\0\1\266\47\0\4\116"+
    "\1\0\1\116\1\0\16\116\1\267\6\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\1\270\24\116\1\0\1\116\6\0\1\116\1\0"+
    "\1\116\16\0\4\116\1\0\1\116\1\0\1\116\1\271"+
    "\23\116\1\0\1\116\6\0\1\116\1\0\1\116\16\0"+
    "\4\116\1\0\1\116\1\0\22\116\1\272\2\116\1\0"+
    "\1\116\6\0\1\116\1\0\1\116\16\0\4\116\1\0"+
    "\1\116\1\0\2\116\1\273\22\116\1\0\1\116\6\0"+
    "\1\116\1\0\1\116\16\0\4\116\1\0\1\116\1\0"+
    "\16\116\1\274\6\116\1\0\1\116\6\0\1\116\1\0"+
    "\1\116\16\0\4\116\1\0\1\116\1\0\6\116\1\275"+
    "\16\116\1\0\1\116\6\0\1\116\1\0\1\116\16\0"+
    "\4\116\1\0\1\116\1\0\13\116\1\276\11\116\1\0"+
    "\1\116\6\0\1\116\1\0\1\116\16\0\4\116\1\0"+
    "\1\116\1\0\25\116\1\0\1\200\6\0\1\116\1\0"+
    "\1\116\26\0\1\277\62\0\1\251\12\0\1\211\104\0"+
    "\1\300\23\0\2\252\5\301\25\252\1\301\1\252\2\301"+
    "\1\0\1\252\1\0\1\301\1\252\1\301\1\252\3\301"+
    "\1\252\1\0\1\301\1\0\1\301\3\0\2\301\22\0"+
    "\1\302\53\0\1\303\57\0\1\304\106\0\1\161\47\0"+
    "\1\305\3\0\1\306\1\0\1\307\55\0\1\221\104\0"+
    "\1\310\65\0\1\311\55\0\1\221\61\0\1\310\71\0"+
    "\1\221\52\0\1\310\53\0\4\116\1\0\1\116\1\0"+
    "\12\116\1\312\12\116\1\0\1\116\6\0\1\116\1\0"+
    "\1\116\16\0\4\116\1\0\1\116\1\0\12\116\1\313"+
    "\12\116\1\0\1\116\6\0\1\116\1\0\1\116\16\0"+
    "\4\116\1\0\1\116\1\0\1\314\24\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\17\116\1\315\5\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\16\0\3\116\1\316\1\0\1\116\1\0"+
    "\25\116\1\0\1\116\6\0\1\116\1\0\1\116\16\0"+
    "\4\116\1\0\1\116\1\0\11\116\1\274\13\116\1\0"+
    "\1\116\6\0\1\116\1\0\1\116\16\0\4\116\1\0"+
    "\1\116\1\0\1\317\24\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\25\0\1\320\116\0\1\252\34\0\1\321"+
    "\62\0\1\311\65\0\1\305\3\0\1\306\72\0\1\322"+
    "\55\0\1\323\71\0\1\232\71\0\1\324\64\0\1\221"+
    "\37\0\4\116\1\0\1\116\1\0\15\116\1\325\7\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\16\116\1\314\6\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\2\116\1\274\22\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\16\0\4\116\1\0\1\116\1\0\16\116"+
    "\1\326\6\116\1\0\1\116\6\0\1\116\1\0\1\116"+
    "\16\0\4\116\1\0\1\116\1\0\13\116\1\325\11\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\11\116\1\327\13\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\27\0\1\330\56\0\1\331"+
    "\64\0\1\332\76\0\1\333\66\0\1\221\45\0\4\116"+
    "\1\0\1\116\1\0\11\116\1\334\13\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\16\0\4\116\1\0\1\116"+
    "\1\0\3\116\1\314\21\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\16\0\4\116\1\0\1\116\1\0\17\116"+
    "\1\335\5\116\1\0\1\116\6\0\1\116\1\0\1\116"+
    "\36\0\1\336\62\0\1\337\57\0\1\340\71\0\1\324"+
    "\46\0\4\116\1\0\1\116\1\0\5\116\1\243\17\116"+
    "\1\0\1\116\6\0\1\116\1\0\1\116\16\0\4\116"+
    "\1\0\1\116\1\0\16\116\1\341\6\116\1\0\1\116"+
    "\6\0\1\116\1\0\1\116\30\0\1\342\67\0\1\343"+
    "\7\0\1\344\62\0\1\345\41\0\4\116\1\0\1\116"+
    "\1\0\12\116\1\274\12\116\1\0\1\116\6\0\1\116"+
    "\1\0\1\116\27\0\1\346\65\0\1\311\63\0\1\214"+
    "\77\0\1\311\37\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[10335];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\1\3\0\1\11\6\1\1\11\2\1\10\11"+
    "\2\1\1\11\2\1\4\11\5\1\1\11\1\1\2\11"+
    "\1\1\1\11\2\1\2\11\1\1\2\11\5\1\1\11"+
    "\2\0\1\11\3\0\1\1\15\0\15\1\1\11\1\1"+
    "\2\0\1\11\3\0\1\1\1\0\2\11\27\0\11\1"+
    "\12\0\1\11\14\0\11\1\3\0\1\1\14\0\10\1"+
    "\13\0\6\1\5\0\3\1\4\0\2\1\3\0\1\1"+
    "\4\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[230];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */

	/**
	 * Internal type denoting a line ending in a CSS property.
	 */
	public static final int INTERNAL_CSS_PROPERTY			= -1;

	/**
	 * Internal type denoting a line ending in a CSS property value.
	 */
	public static final int INTERNAL_CSS_VALUE				= -2;

	/**
	 * Internal type denoting line ending in a CSS double-quote string.
	 * The state to return to is embedded in the actual end token type.
	 */
	public static final int INTERNAL_CSS_STRING				= -(1<<11);

	/**
	 * Internal type denoting line ending in a CSS single-quote string.
	 * The state to return to is embedded in the actual end token type.
	 */
	public static final int INTERNAL_CSS_CHAR				= -(2<<11);

	/**
	 * Internal type denoting line ending in a CSS multi-line comment.
	 * The state to return to is embedded in the actual end token type.
	 */
	public static final int INTERNAL_CSS_MLC				= -(3<<11);

	/**
	 * The state previous CSS-related state we were in before going into a CSS
	 * string, multi-line comment, etc.
	 */
	private int cssPrevState;

	/**
	 * Whether we are highlighting less instead of CSS.
	 */
	private boolean highlightingLess;


	/**
	 * Constructor.  This must be here because JFlex does not generate a
	 * no-parameter constructor.
	 */
	public CSSTokenMaker() {
		super();
	}


	/**
	 * Adds the token specified to the current linked list of tokens as an
	 * "end token;" that is, at <code>zzMarkedPos</code>.
	 *
	 * @param tokenType The token's type.
	 */
	private void addEndToken(int tokenType) {
		addToken(zzMarkedPos,zzMarkedPos, tokenType);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addToken(int, int, int)
	 */
	private void addHyperlinkToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, true);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int tokenType) {
		addToken(zzStartRead, zzMarkedPos-1, tokenType);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param array The character array.
	 * @param start The starting offset in the array.
	 * @param end The ending offset in the array.
	 * @param tokenType The token's type.
	 * @param startOffset The offset in the document at which this token
	 *                    occurs.
	 */
	@Override
	public void addToken(char[] array, int start, int end, int tokenType, int startOffset) {
		super.addToken(array, start,end, tokenType, startOffset);
		zzStartRead = zzMarkedPos;
	}


	/**
	 * Returns the closest {@link TokenTypes "standard" token type} for a given
	 * "internal" token type (e.g. one whose value is <code>&lt; 0</code>).
	 */
	@Override
	public int getClosestStandardTokenTypeForInternalType(int type) {
		switch (type) {
			case INTERNAL_CSS_STRING:
			case INTERNAL_CSS_CHAR:
				return TokenTypes.LITERAL_STRING_DOUBLE_QUOTE;
			case INTERNAL_CSS_MLC:
				return TokenTypes.COMMENT_MULTILINE;
		}
		return type;
	}


	/**
	 * Returns <code>true</code> since CSS uses curly braces.
	 *
	 * @return <code>true</code> always.
	 */
	public boolean getCurlyBracesDenoteCodeBlocks() {
		return true;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getMarkOccurrencesOfTokenType(int type) {
		return type==Token.RESERVED_WORD; // Used for CSS keys
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getShouldIndentNextLineAfter(Token t) {
		if (t!=null && t.length()==1) {
			char ch = t.charAt(0);
			return ch=='{' || ch=='(';
		}
		return false;
	}


	/**
	 * Returns the first token in the linked list of tokens generated
	 * from <code>text</code>.  This method must be implemented by
	 * subclasses so they can correctly implement syntax highlighting.
	 *
	 * @param text The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset The offset into the document at which
	 *        <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing
	 *         the syntax highlighted text.
	 */
	public Token getTokenList(Segment text, int initialTokenType, int startOffset) {

		resetTokenList();
		this.offsetShift = -text.offset + startOffset;
		cssPrevState = YYINITIAL; // Shouldn't be necessary

		// Start off in the proper state.
		int state = Token.NULL;
		switch (initialTokenType) {
			case Token.LITERAL_STRING_DOUBLE_QUOTE:
				state = CSS_STRING;
				break;
			case Token.LITERAL_CHAR:
				state = CSS_CHAR_LITERAL;
				break;
			case Token.COMMENT_MULTILINE:
				state = CSS_C_STYLE_COMMENT;
				break;
			case INTERNAL_CSS_PROPERTY:
				state = CSS_PROPERTY;
				break;
			case INTERNAL_CSS_VALUE:
				state = CSS_VALUE;
				break;
			default:
				if (initialTokenType<-1024) {
					int main = -(-initialTokenType & 0xffffff00);
					switch (main) {
						default: // Should never happen
						case INTERNAL_CSS_STRING:
							state = CSS_STRING;
							break;
						case INTERNAL_CSS_CHAR:
							state = CSS_CHAR_LITERAL;
							break;
						case INTERNAL_CSS_MLC:
							state = CSS_C_STYLE_COMMENT;
							break;
					}
					cssPrevState = -initialTokenType&0xff;
				}
				else {
					state = Token.NULL;
				}
		}

		start = text.offset;
		s = text;
		try {
			yyreset(zzReader);
			yybegin(state);
			return yylex();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new TokenImpl();
		}

	}


	/**
	 * Overridden to accept letters, digits, underscores, and hyphens.
	 */
	@Override
	public boolean isIdentifierChar(int languageIndex, char ch) {
		return Character.isLetterOrDigit(ch) || ch=='-' || ch=='.' || ch=='_';
	}


	/**
	 * Toggles whether we're highlighting less instead of just CSS.
	 *
	 * @param highlightingLess Whether we're highlighting less.
	 */
	public void setHighlightingLess(boolean highlightingLess) {
		this.highlightingLess = highlightingLess;
	}


	/**
	 * Refills the input buffer.
	 *
	 * @return      <code>true</code> if EOF was reached, otherwise
	 *              <code>false</code>.
	 */
	private boolean zzRefill() {
		return zzCurrentPos>=s.offset+s.count;
	}


	/**
	 * Resets the scanner to read from a new input stream.
	 * Does not close the old reader.
	 *
	 * All internal variables are reset, the old input stream 
	 * <b>cannot</b> be reused (internal buffer is discarded and lost).
	 * Lexical state is set to <tt>YY_INITIAL</tt>.
	 *
	 * @param reader   the new input stream 
	 */
	public final void yyreset(java.io.Reader reader) {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill
		 * no longer "refills" the buffer (since the way we do it, it's always
		 * "full" the first time through, since it points to the segment's
		 * array).  So, we assign zzEndRead here.
		 */
		//zzStartRead = zzEndRead = s.offset;
		zzStartRead = s.offset;
		zzEndRead = zzStartRead + s.count - 1;
		zzCurrentPos = zzMarkedPos = s.offset;
		zzLexicalState = YYINITIAL;
		zzReader = reader;
		zzAtEOF  = false;
	}




  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CSSTokenMaker(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public CSSTokenMaker(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 134) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  @Override
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public org.fife.ui.rsyntaxtextarea.Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { addToken(Token.IDENTIFIER);
          }
        case 41: break;
        case 2: 
          { /*System.out.println("yyinitial: " + yytext());*/ addToken(Token.IDENTIFIER);
          }
        case 42: break;
        case 24: 
          { addEndToken(INTERNAL_CSS_VALUE); return firstToken;
          }
        case 43: break;
        case 40: 
          { addToken(Token.PREPROCESSOR);
          }
        case 44: break;
        case 9: 
          { addToken(Token.SEPARATOR); yybegin(CSS_PROPERTY);
          }
        case 45: break;
        case 28: 
          { addToken(start,zzStartRead, Token.LITERAL_STRING_DOUBLE_QUOTE); yybegin(cssPrevState);
          }
        case 46: break;
        case 31: 
          { addToken(start,zzStartRead-1, Token.LITERAL_CHAR); addEndToken(INTERNAL_CSS_CHAR - cssPrevState); return firstToken;
          }
        case 47: break;
        case 35: 
          { start = zzMarkedPos-2; cssPrevState = zzLexicalState; yybegin(CSS_C_STYLE_COMMENT);
          }
        case 48: break;
        case 30: 
          { addToken(start,zzStartRead, Token.LITERAL_CHAR); yybegin(cssPrevState);
          }
        case 49: break;
        case 37: 
          { addToken(start,zzStartRead+1, Token.COMMENT_MULTILINE); yybegin(cssPrevState);
          }
        case 50: break;
        case 12: 
          { addToken(highlightingLess ? Token.SEPARATOR : Token.IDENTIFIER);
          }
        case 51: break;
        case 10: 
          { start = zzMarkedPos-1; cssPrevState = zzLexicalState; yybegin(CSS_STRING);
          }
        case 52: break;
        case 16: 
          { addToken(Token.OPERATOR); yybegin(CSS_VALUE);
          }
        case 53: break;
        case 5: 
          { /* Unknown pseudo class */ addToken(Token.DATA_TYPE);
          }
        case 54: break;
        case 22: 
          { addToken(Token.OPERATOR); yybegin(CSS_PROPERTY);
          }
        case 55: break;
        case 27: 
          { /* Skip escaped chars. */
          }
        case 56: break;
        case 39: 
          { addToken(Token.REGEX);
          }
        case 57: break;
        case 34: 
          { addToken(highlightingLess ? Token.ANNOTATION : Token.VARIABLE);
          }
        case 58: break;
        case 3: 
          { addToken(highlightingLess ? Token.LITERAL_NUMBER_DECIMAL_INT : Token.IDENTIFIER);
          }
        case 59: break;
        case 19: 
          { addEndToken(INTERNAL_CSS_PROPERTY); return firstToken;
          }
        case 60: break;
        case 23: 
          { int temp = zzMarkedPos - 2;
						  addToken(zzStartRead, temp, Token.FUNCTION);
						  addToken(zzMarkedPos-1, zzMarkedPos-1, Token.SEPARATOR);
						  zzStartRead = zzCurrentPos = zzMarkedPos;
          }
        case 61: break;
        case 7: 
          { addToken(Token.WHITESPACE);
          }
        case 62: break;
        case 18: 
          { addToken(Token.SEPARATOR); yybegin(YYINITIAL);
          }
        case 63: break;
        case 4: 
          { addToken(Token.DATA_TYPE);
          }
        case 64: break;
        case 33: 
          { addToken(highlightingLess ? Token.VARIABLE : Token.REGEX);
          }
        case 65: break;
        case 17: 
          { addToken(Token.SEPARATOR); /* helps with auto-closing curlies when editing CSS */
          }
        case 66: break;
        case 21: 
          { addToken(Token.LITERAL_NUMBER_DECIMAL_INT);
          }
        case 67: break;
        case 29: 
          { addToken(start,zzStartRead-1, Token.LITERAL_STRING_DOUBLE_QUOTE); addEndToken(INTERNAL_CSS_STRING - cssPrevState); return firstToken;
          }
        case 68: break;
        case 32: 
          { addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); addEndToken(INTERNAL_CSS_MLC - cssPrevState); return firstToken;
          }
        case 69: break;
        case 25: 
          { /* End of a function */ addToken(Token.SEPARATOR);
          }
        case 70: break;
        case 36: 
          { addToken(highlightingLess ? Token.VARIABLE : Token.IDENTIFIER);
          }
        case 71: break;
        case 14: 
          { /*System.out.println("css_property: " + yytext());*/ addToken(Token.IDENTIFIER);
          }
        case 72: break;
        case 15: 
          { addToken(Token.RESERVED_WORD);
          }
        case 73: break;
        case 38: 
          { int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); addHyperlinkToken(temp,zzMarkedPos-1, Token.COMMENT_MULTILINE); start = zzMarkedPos;
          }
        case 74: break;
        case 11: 
          { start = zzMarkedPos-1; cssPrevState = zzLexicalState; yybegin(CSS_CHAR_LITERAL);
          }
        case 75: break;
        case 6: 
          { addToken(Token.SEPARATOR);
          }
        case 76: break;
        case 13: 
          { addNullToken(); return firstToken;
          }
        case 77: break;
        case 8: 
          { addToken(Token.OPERATOR);
          }
        case 78: break;
        case 20: 
          { /*System.out.println("css_value: " + yytext());*/ addToken(Token.IDENTIFIER);
          }
        case 79: break;
        case 26: 
          { 
          }
        case 80: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case CSS_C_STYLE_COMMENT: {
              addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); addEndToken(INTERNAL_CSS_MLC - cssPrevState); return firstToken;
            }
            case 231: break;
            case YYINITIAL: {
              addNullToken(); return firstToken;
            }
            case 232: break;
            case CSS_STRING: {
              addToken(start,zzStartRead-1, Token.LITERAL_STRING_DOUBLE_QUOTE); addEndToken(INTERNAL_CSS_STRING - cssPrevState); return firstToken;
            }
            case 233: break;
            case CSS_VALUE: {
              addEndToken(INTERNAL_CSS_VALUE); return firstToken;
            }
            case 234: break;
            case CSS_PROPERTY: {
              addEndToken(INTERNAL_CSS_PROPERTY); return firstToken;
            }
            case 235: break;
            case CSS_CHAR_LITERAL: {
              addToken(start,zzStartRead-1, Token.LITERAL_CHAR); addEndToken(INTERNAL_CSS_CHAR - cssPrevState); return firstToken;
            }
            case 236: break;
            default:
            return null;
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
