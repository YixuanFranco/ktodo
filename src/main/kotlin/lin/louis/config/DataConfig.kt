package lin.louis.config

import java.io.Reader
import java.util.*

const val DATA_FOLDER = "data.folder"
const val DATA_FILE = "ktodo"

data class DataConfig(val dataFilePath: String)

fun getConfigFromFile(reader: Reader): DataConfig {
    val properties = Properties()
    properties.load(reader)
    var dataFolder = properties.getProperty(DATA_FOLDER, "/tmp")
    return DataConfig("$dataFolder/$DATA_FILE")
}