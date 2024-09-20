<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SimpleHabits</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>

<body class="bg-slate-100">
<div class="p-4 bg-blue-900 text-white flex">
        <span class="grow  text-lg font-bold font-mono">
            <a href="/">SimpleHabits</a>
        </span></div>

<div class="p-4 flex flex-col gap-2">
    <span class="font-mono grow">Criando um novo hábito...</span>
</div>

<form class="p-4 flex flex-col gap-3" action="/criar-habito" method="post">
    <input type="text" name="titulo" placeholder="Título do hábito" class="px-2 py-4 rounded-md shadow-sm max-w-lg" autofocus
           required />
    <div class="flex gap-3 flex-row">
        <input type="number" name="ocorrencias" placeholder="Ocorrências" class="px-2 py-4 rounded-md shadow-sm" min="1"
               value="1" required/>
        <select name="recorrencia" class="px-2 py-4 rounded-md shadow-sm" required>
            <option value="DIARIO">Diário</option>
            <option value="SEMANAL">Semanal</option>
            <option value="QUINZENAL">Quinzenal</option>
            <option value="MENSAL">Mensal</option>
        </select>
    </div>

    <input type="submit"
           class="text-center px-2 py-4 bg-blue-500 rounded-md text-white font-bold max-w-lg cursor-pointer"
           value="Criar novo hábito">
</form>
</body>

</html>