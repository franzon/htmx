@import dev.franzon.habittracker.dto.Habito

@param Habito habito

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SimpleHabits</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <script>
        function excluirHabito(id) {
            const confirmed = window.confirm('Are you sure you want to delete this item?');

            if (confirmed) {
                fetch('/excluir-habito/${habito.getId()}', {
                    method: 'DELETE'
                }).then(response => {
                    window.location.href = "http://localhost:8080/habitos"
                });
            }
        }
    </script>
</head>

<body class="bg-slate-100">
<div class="p-4 bg-blue-900 text-white flex">
        <span class="grow  text-lg font-bold font-mono">
            <a href="/">SimpleHabits</a>
        </span>
</div>
<div class="p-4 flex flex-col gap-3">
    <form class="flex flex-col gap-3" action="/atualizar-habito" method="post">
        <input type="hidden" name="id" value="${habito.getId()}" />
        <input type="text"
               name="titulo"
               placeholder="Título do hábito"
               class="px-2 py-4 rounded-md shadow-sm max-w-lg"
               autofocus
               required
               value="${habito.getTitulo()}"/>
        <div class="flex gap-3 flex-row">
            <input type="number"
                   name="ocorrencias"
                   placeholder="Ocorrências"
                   class="px-2 py-4 rounded-md shadow-sm"
                   min="1"
                   value="${habito.getOcorrencias()}"
                   required/>
            <select name="recorrencia"
                    class="px-2 py-4 rounded-md shadow-sm"
                    required
            >
                <option value="DIARIO" selected="${habito.getRecorrencia().name().equals("DIARIO")}">Diário</option>
                <option value="SEMANAL" selected="${habito.getRecorrencia().name().equals("SEMANAL")}">Semanal</option>
                <option value="QUINZENAL" selected="${habito.getRecorrencia().name().equals("QUINZENAL")}">Quinzenal</option>
                <option value="MENSAL" selected="${habito.getRecorrencia().name().equals("MENSAL")}">Mensal</option>
            </select>
        </div>

        <input type="submit"
               class="text-center px-2 py-4 bg-amber-700 rounded-md text-white font-bold max-w-lg cursor-pointer"
               value="Salvar">
    </form>
    <button class="text-center px-2 py-4 bg-red-500 rounded-md max-w-lg" onclick="excluirHabito(${habito.getId()})">Excluir</button>
</div>

</body>

</html>