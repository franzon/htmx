package gg.jte.generated.ondemand;
import dev.franzon.habittracker.dto.Habito;
import java.util.List;
public final class JtehabitosGenerated {
	public static final String JTE_NAME = "habitos.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,35,35,35,36,36,36,36,38,38,38,44,44,48,48,48,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Habito> habitos) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>SimpleHabits</title>\r\n    <script src=\"https://cdn.tailwindcss.com\"></script>\r\n    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\" rel=\"stylesheet\">\r\n</head>\r\n\r\n<body class=\"bg-slate-100\">\r\n<div class=\"p-4 bg-blue-900 text-white flex\">\r\n        <span class=\"grow  text-lg font-bold font-mono\">\r\n            <a href=\"/\">SimpleHabits</a>\r\n        </span>\r\n    <a href=\"/\">\r\n        <i class=\"fa-solid fa-check\"></i>\r\n    </a>\r\n</div>\r\n\r\n<div class=\"p-4 flex flex-col gap-2\">\r\n    <span class=\"font-mono grow\">Estes são meus hábitos cadastrados...</span>\r\n    <a href=\"criar-habito\" class=\"text-center px-2 py-4 bg-blue-500 rounded-md text-white font-bold max-w-lg\">\r\n        <i class=\"fa-solid fa-add\"></i>\r\n        Criar novo hábito\r\n    </a>\r\n</div>\r\n<div class=\"p-4 flex flex-col gap-3\">\r\n\r\n    ");
		for (Habito habito : habitos) {
			jteOutput.writeContent("\r\n        <a href=\"/habitos/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(habito.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">\r\n            <div class=\"bg-white p-6 rounded-md shadow-md flex max-w-lg\">\r\n                <span class=\"grow\">");
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(habito.getTitulo());
			jteOutput.writeContent("</span>\r\n                <div class=\"space-x-2\">\r\n                    <i class=\"fa-solid fa-edit\"></i>\r\n                </div>\r\n            </div>\r\n        </a>\r\n    ");
		}
		jteOutput.writeContent("\r\n</div>\r\n</body>\r\n\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Habito> habitos = (List<Habito>)params.get("habitos");
		render(jteOutput, jteHtmlInterceptor, habitos);
	}
}
