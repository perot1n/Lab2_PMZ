package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.entity.File

interface FileService {
    fun create(file: File): File
    fun getById(id: Long): File?
    fun update(file: File): File
    fun deleteById(id: Long)
    fun getAll(): List<File>
}
