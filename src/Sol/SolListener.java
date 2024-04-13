// Generated from C:/Users/fpgue/Desktop/Trabalhos Uni/Compiladores2324/UNI/SolCompiler/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SolParser}.
 */
public interface SolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SolParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SolParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SolParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(SolParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(SolParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterOr(SolParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitOr(SolParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(SolParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(SolParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterEqual(SolParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitEqual(SolParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SolParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SolParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SolParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SolParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rel}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterRel(SolParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rel}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitRel(SolParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterUnary(SolParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitUnary(SolParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterParen(SolParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitParen(SolParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(SolParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(SolParser.MultDivContext ctx);
}