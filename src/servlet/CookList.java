package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cook;
import entity.Foods_cook;
import entity.Tools_cook;
import util.DBUtil;

@WebServlet("/CookList")
public class CookList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CookList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String p = request.getParameter("person");
        String m = request.getParameter("money");
        int money = 0;
        int persons = 0;
        List<String> errors = new ArrayList<String>();
        if (m == null || m.trim().isEmpty()) {
            errors.add("金額を入力してください");
        } else {
            try {
                money = Integer.parseInt(m);
            } catch (NumberFormatException e) {
                errors.add("金額には数字を入れてください");
            }
        }
        if (p == null || p.trim().isEmpty()) {
            errors.add("人数を入力してください");
        } else {
            try {
                money = Integer.parseInt(m);
            } catch (NumberFormatException e) {
                errors.add("人数には数字を入れてください");
            }
        }
        if (errors.size() != 0) {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodBudget.jsp");
            rd.forward(request, response);
        }
        Cook c = null;
        ArrayList<Cook> aryCook = new ArrayList<Cook>();
        String[] fooParams = (String[]) request.getSession().getAttribute("food_id");
        if (fooParams != null) {
            EntityManager em = DBUtil.createEntityManager();
            ArrayList<Foods_cook> aryFoodscook = new ArrayList<Foods_cook>(); //ArrayListをFoods_cook型のaryFoodsCook変数で作成 aryFoodsCookには、Foods_cookオブジェクトが入る
            //ArrayList<Cook> aryCook = new ArrayList<Cook>(); //ArrayListをCook型のaryCook変数で作成 aryCookには、Cookオブジェクトが入る
            Foods_cook f = null; //Foods_cook型の変数fを宣言
            for (String fooParam : fooParams) { //拡張for文で28行目で取得した、fooParamsのリストのパラメータを一つずつfooParamに入れる
                f = em.createNamedQuery("selectFoodId", Foods_cook.class) //createNamedQueryメソッドでFoods_cook.javaのJPQL selectFoodIdを実行
                        .setParameter("foods_id", Integer.parseInt(fooParam)) //第一引数の"foods_id"で、第二引数のfooParamのパラメータを、Foods_cook.javaのEntityの@NamedQuery"selectFoodId"のqueryの:foods_id"に入れて、同じものをFoods_cook,Entityのfoods_idから検索する
                        .getSingleResult(); //１件取得する
                aryFoodscook.add(f); //ArrayList<Foods_cook>のaryFoodscookに取得したオブジェクトを追加
            }
            //Cook c = null; //Cook型の変数cを宣言
            int num; //num変数を宣言
            for (Foods_cook fc : aryFoodscook) { //ArrayList<Foods_cook>のaryFoodscookに格納されたオブジェクトfを１つずつfcに入れる
                num = fc.getCook_id(); //Foods_cook.javaのfcオブジェクトのCook_idをgetterで取得
                c = em.createNamedQuery("selectCookId", Cook.class) //createNamedQueryメソッドでCook.javaの "selectCookId"を実行
                        .setParameter("cook_id", num) //第一引数の"cook_id"で、第二引数のnumのパラメータを、Cook.javaのEntityの＠NamedQuery"selectCookId"のQueryの:cook_idにいれて、同じものをCookテーブルのcook.idから検索
                        .getSingleResult(); //1行取得
                aryCook.add(c); //ArrayList<Cook>の変数aryCookに取得したオブジェクトを追加
            }
            ArrayList<Cook> aryResult = new ArrayList<Cook>();
            for (int i = 0; i < aryCook.size(); i++) {
                int cookId = aryCook.get(i).getCook_id();//arrayListに入っている数を取り出しcookIdに入れる
                int j = 0;
                System.out.println("cookId" + cookId);
                for (; j < aryResult.size(); j++) {
                    System.out.println("aryResult" + aryResult.get(j).getCook_id());
                    if (cookId == aryResult.get(j).getCook_id()) {
                        break;
                    }
                }
                if (j == aryResult.size()) {
                    if (aryCook.get(i).getCook_cost() < money) {
                        //Cook cook = aryCook.get(i);
                        //Integer cost = cook.getCook_cost();
                        System.out.println("cookId2" + cookId);
                        aryResult.add(aryCook.get(i));
                    }
                }
            }
            request.setAttribute("cook", aryResult);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/cookList2.jsp");
            rd.forward(request, response);
        } else {
            EntityManager e = DBUtil.createEntityManager();
            String[] fooToolParams = (String[]) request.getSession().getAttribute("tool_id");
            ArrayList<Tools_cook> aryTools = new ArrayList<Tools_cook>();
            //ArrayList<Cook> aryTool = new ArrayList<Cook>();
            Tools_cook tc = null;
            for (String fooToolParam : fooToolParams) {
                tc = e.createNamedQuery("selectToolId", Tools_cook.class)
                        .setParameter("tools_id", Integer.parseInt(fooToolParam))
                        .getSingleResult();
                aryTools.add(tc);
            }
            //Tool t = null; //Cook型の変数cを宣言
            int numTool; //num変数を宣言
            for (Tools_cook to : aryTools) { //ArrayList<Foods_cook>のaryFoodscookに格納されたオブジェクトfを１つずつfcに入れる
                numTool = to.getCook_id(); //Foods_cook.javaのfcオブジェクトのCook_idをgetterで取得
                c = e.createNamedQuery("selectCookId", Cook.class) //createNamedQueryメソッドでCook.javaの "selectCookId"を実行
                        .setParameter("cook_id", numTool) //第一引数の"cook_id"で、第二引数のnumのパラメータを、Cook.javaのEntityの＠NamedQuery"selectCookId"のQueryの:cook_idにいれて、同じものをCookテーブルのcook.idから検索
                        .getSingleResult(); //1行取得
                aryCook.add(c); //ArrayList<Cook>の変数aryCookに取得したオブジェクトを追加
            }
            ArrayList<Cook> aryToolResult = new ArrayList<Cook>();
            for (int i = 0; i < aryCook.size(); i++) {
                int cookIdTool = aryCook.get(i).getCook_id();
                int j = 0;
                System.out.println("cookId" + cookIdTool);
                for (; j < aryToolResult.size(); j++) {
                    if (cookIdTool == aryToolResult.get(j).getCook_id()) {
                        System.out.println("aryToolResult" + aryToolResult.get(j).getCook_id());
                        break;
                    }
                }
                if (j == aryToolResult.size()) {
                    if (aryCook.get(i).getCook_cost() < money) {
                        System.out.println("cookIdT" + cookIdTool);
                        aryToolResult.add(aryCook.get(i));
                    }
                }
            }
            request.setAttribute("cookTool", aryToolResult);
            RequestDispatcher rd2 = request.getRequestDispatcher("/WEB-INF/cookList2.jsp");
            rd2.forward(request, response);

        }
    }

}
