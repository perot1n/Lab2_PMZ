package ua.kpi.its.lab.rest.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.entity.File
import ua.kpi.its.lab.rest.repo.FileRepository
import ua.kpi.its.lab.rest.svc.FileService

@Service
class FileServiceImpl @Autowired constructor(
    private val fileRepository: FileRepository
) : FileService {
    override fun create(file: File): File {
        return fileRepository.save(file)
    }

    override fun getById(id: Long): File? {
        return fileRepository.findById(id).orElse(null)
    }

    override fun update(file: File): File {
        return fileRepository.save(file)
    }

    override fun deleteById(id: Long) {
        fileRepository.deleteById(id)
    }

    override fun getAll(): List<File> {
        return fileRepository.findAll()
    }
}
