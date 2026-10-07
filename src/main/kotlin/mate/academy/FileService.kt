package mate.academy

import java.io.File
import java.io.IOException

class FileService {
    fun readFile(fileName: String): Result<String> {
        return runCatching {
            val file = File(fileName)

            if (!file.isFile) {
                throw IOException(
                    "File does not exist or is not a valid file $fileName"
                )
            }

            file.readText()
        }
    }

    fun processFileContent(fileName: String): String {
        val result = readFile(fileName)

        return result.fold(
            onSuccess = { content ->
                TODO("Верни content в верхнем регистре")
            },
            onFailure = { exception ->
                TODO("Верни Error: Cannot read file - <EXCEPTION_MESSAGE>")
            }
        )
    }
}
