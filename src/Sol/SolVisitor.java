// Generated from C:/Users/fpgue/Desktop/Trabalhos Uni/Compiladores2324/UNI/SolCompiler/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SolParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SolParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(SolParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SolParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(SolParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(SolParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SolParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SolParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rel}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel(SolParser.RelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(SolParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(SolParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link SolParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDiv(SolParser.MultDivContext ctx);
}