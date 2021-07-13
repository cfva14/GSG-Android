package org.b12x.gfe.plugins.gfesearch.controller

enum class HlaLoci(val fullName: String, val exons: Int){
    A("HLA-A", 8), //{
//        override fun getFullName() = fullName
//                  },
    B("HLA-B",7),
    C("HLA-C",8),
    DPA1("HLA-DPA1",4),
    DPB1("HLA-DPB1",5),
    DQA1("HLA-DQA1",4),
    DQB1("HLA-DQB1",6),
    DRB1("HLA-DRB1",6),
    DRB3("HLA-DRB3",6),
    DRB4("HLA-DRB4",6),
    DRB5("HLA-DRB5",6);

    override fun toString(): String {
        return fullName // working!
    }


}

interface FullName {
    fun getFullName(): String
}