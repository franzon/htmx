@import dev.franzon.habittracker.dto.Habito
@import java.util.List

@param List<Habito> habitos

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
        </span>
    <a href="/">
        <i class="fa-solid fa-check"></i>
    </a>
</div>

<div class="p-4 flex flex-col gap-2">
    <span class="font-mono grow">Estes são meus hábitos cadastrados...</span>
    <a href="criar-habito" class="text-center px-2 py-4 bg-blue-500 rounded-md text-white font-bold max-w-lg">
        <i class="fa-solid fa-add"></i>
        Criar novo hábito
    </a>
</div>
<div class="p-4 flex flex-col gap-3">

    @for(Habito habito : habitos)
        <a href="/habitos/${habito.getId()}">
            <div class="bg-white p-6 rounded-md shadow-md flex max-w-lg">
                <span class="grow">${habito.getTitulo()}</span>
                <div class="space-x-2">
                    <i class="fa-solid fa-edit"></i>
                </div>
            </div>
        </a>
    @endfor
</div>
</body>

</html>