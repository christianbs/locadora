import br.com.locadora.constante.EstadoConservacao;
import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.dados.impl.DiscoDAOImpl;
import br.com.locadora.dados.impl.FilmeDAOImpl;
import br.com.locadora.entidade.Disco;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.excessao.ExcecaoNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadDiscoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ExcecaoNegocio, IOException{
        long id_filme = Long.parseLong(request.getParameter("id_filme"));
        EstadoConservacao estado = EstadoConservacao.recuperarEstadoConservacao(request.getParameter("estado"));
        boolean alocado = Boolean.parseBoolean(request.getParameter("alocado"));
        FilmeDAO fdao = new FilmeDAOImpl();
        DiscoDAO ddao = new DiscoDAOImpl();
        Filme f;
        Disco d;
        try {
            f = fdao.buscarPeloId(id_filme);
        } catch (ExcecaoAcessoDados ex) {
            throw new ExcecaoNegocio(ex.getException());
        }
        if(f != null){
            d = new Disco(alocado, f, estado);
            try {
                ddao.criar(d);
                PrintWriter saida = response.getWriter();
                saida.println("alert('Disco criado com sucesso!')");
            } catch (ExcecaoAcessoDados ex) {
                throw new ExcecaoNegocio(ex.getException());
            }
        }
        RequestDispatcher view = request.getRequestDispatcher("index.html");
      
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadDiscoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadDiscoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
