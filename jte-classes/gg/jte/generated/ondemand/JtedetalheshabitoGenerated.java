package gg.jte.generated.ondemand;
import dev.franzon.habittracker.dto.Habito;
public final class JtedetalheshabitoGenerated {
	public static final String JTE_NAME = "detalhes-habito.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,19,19,19,19,37,37,37,37,37,37,37,37,37,44,44,44,44,44,44,44,44,44,51,51,51,51,51,51,51,51,51,57,57,57,57,57,58,58,58,58,58,59,59,59,59,59,60,60,60,60,60,68,68,68,68,73,73,73,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Habito habito) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>SimpleHabits</title>\r\n    <script src=\"https://cdn.tailwindcss.com\"></script>\r\n    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\" rel=\"stylesheet\">\r\n\r\n    <script>\r\n        function excluirHabito(id) {\r\n            const confirmed = window.confirm('Are you sure you want to delete this item?');\r\n\r\n            if (confirmed) {\r\n                fetch('/excluir-habito/");
		jteOutput.setContext("script", null);
		jteOutput.writeUserContent(habito.getId());
		jteOutput.writeContent("', {\r\n                    method: 'DELETE'\r\n                }).then(response => {\r\n                    window.location.href = \"http://localhost:8080/habitos\"\r\n                });\r\n            }\r\n        }\r\n    </script>\r\n</head>\r\n\r\n<body class=\"bg-slate-100\">\r\n<div class=\"p-4 bg-blue-900 text-white flex\">\r\n        <span class=\"grow  text-lg font-bold font-mono\">\r\n            <a href=\"/\">SimpleHabits</a>\r\n        </span>\r\n</div>\r\n<div class=\"p-4 flex flex-col gap-3\">\r\n    <form class=\"flex flex-col gap-3\" action=\"/atualizar-habito\" method=\"post\">\r\n        <input type=\"hidden\" name=\"id\"");
		var __jte_html_attribute_0 = habito.getId();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n        <input type=\"text\"\r\n               name=\"titulo\"\r\n               placeholder=\"Título do hábito\"\r\n               class=\"px-2 py-4 rounded-md shadow-sm max-w-lg\"\r\n               autofocus\r\n               required\r\n              ");
		var __jte_html_attribute_1 = habito.getTitulo();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n        <div class=\"flex gap-3 flex-row\">\r\n            <input type=\"number\"\r\n                   name=\"ocorrencias\"\r\n                   placeholder=\"Ocorrências\"\r\n                   class=\"px-2 py-4 rounded-md shadow-sm\"\r\n                   min=\"1\"\r\n                  ");
		var __jte_html_attribute_2 = habito.getOcorrencias();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("\r\n                   required/>\r\n            <select name=\"recorrencia\"\r\n                    class=\"px-2 py-4 rounded-md shadow-sm\"\r\n                    required\r\n            >\r\n                <option value=\"DIARIO\"");
		var __jte_html_attribute_3 = habito.getRecorrencia().name().equals("DIARIO");
		if (__jte_html_attribute_3) {
		jteOutput.writeContent(" selected");
		}
		jteOutput.writeContent(">Diário</option>\r\n                <option value=\"SEMANAL\"");
		var __jte_html_attribute_4 = habito.getRecorrencia().name().equals("SEMANAL");
		if (__jte_html_attribute_4) {
		jteOutput.writeContent(" selected");
		}
		jteOutput.writeContent(">Semanal</option>\r\n                <option value=\"QUINZENAL\"");
		var __jte_html_attribute_5 = habito.getRecorrencia().name().equals("QUINZENAL");
		if (__jte_html_attribute_5) {
		jteOutput.writeContent(" selected");
		}
		jteOutput.writeContent(">Quinzenal</option>\r\n                <option value=\"MENSAL\"");
		var __jte_html_attribute_6 = habito.getRecorrencia().name().equals("MENSAL");
		if (__jte_html_attribute_6) {
		jteOutput.writeContent(" selected");
		}
		jteOutput.writeContent(">Mensal</option>\r\n            </select>\r\n        </div>\r\n\r\n        <input type=\"submit\"\r\n               class=\"text-center px-2 py-4 bg-amber-700 rounded-md text-white font-bold max-w-lg cursor-pointer\"\r\n               value=\"Salvar\">\r\n    </form>\r\n    <button class=\"text-center px-2 py-4 bg-red-500 rounded-md max-w-lg\" onclick=\"excluirHabito(");
		jteOutput.setContext("button", "onclick");
		jteOutput.writeUserContent(habito.getId());
		jteOutput.setContext("button", null);
		jteOutput.writeContent(")\">Excluir</button>\r\n</div>\r\n\r\n</body>\r\n\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Habito habito = (Habito)params.get("habito");
		render(jteOutput, jteHtmlInterceptor, habito);
	}
}
