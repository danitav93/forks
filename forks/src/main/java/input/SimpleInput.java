package input;

import java.util.HashMap;

public class SimpleInput implements InputInterface{

	@Override
	public String getS() {
	
		//return "((A,B)!H1,C)!H0";
		
		//ok
	
		// 1) return "((A,B)!H1,C)!H0";
		
		// 2) return "((A,B)!H1,C)!H0";
		
		// 3) return "((A,B)!H1,C)!H0";
		
		// 4) return "((D,((A,B)!H4,(C,F)!H7)!H3)!H1,E)!H0";
		
		//AS
		//return "((((Chipping_Sparrow,(((Y_headed_Blackbird,Brewer_Blackbird)!H7,Bullock_Oriole)!H6,(Y_rumped_Warbler,Grace_Warbler)!H11)!H5)!H3,(Indigo_Bunting,B_headed_Grosbeak)!H14)!H2,((American_Robin,Western_Bluebird)!H18,((Brown_Creeper,Bg_Gnatcatcher)!H22,W_breasted_Nuthatch)!H21)!H17)!H1,(((Western_Kingbird,Scissor_tailed_Flycatcher)!H28,(Ash_throated_Flycatcher,Great_crested_Flycatcher)!H31)!H27,(Gray_Flycatcher,Hammond_Flycatcher)!H34)!H26)!H0";
				
		//CA
		//return "(((c_muricata,((((((c_lachenalii,c_heleonastes)!H9,c_brunnescens)!H8,c_chordorrhiza)!H7,(c_arenaria,(c_dioica,(c_parallela,c_davalliana)!H18)!H16)!H14)!H6,c_paniculata)!H5,c_echinata)!H4)!H2,((((((((((((c_hirta,(c_riparia,c_lasiocarpa)!H36)!H34,(c_rostrata,c_vesicaria)!H39)!H33,(c_magellanica,c_limosa)!H42)!H32,(c_elata,c_bigelowii)!H45)!H31,c_globularis)!H30,c_capillaris)!H29,c_hostiana)!H28,c_atrofusca)!H27,(c_digitata,c_ornithopoda)!H52)!H26,(c_meadii,c_panicea)!H55)!H25,((c_flacca,c_ferruginea)!H59,(c_firma,c_sempervirens)!H62)!H58)!H24,(c_alba,(c_buxbaumii,(c_pilulifera,c_glacialis)!H69)!H67)!H65)!H23)!H1,(((c_rupestris,u_rubra)!H74,k_myosuroides)!H73,(c_baldensis,c_curvula)!H78)!H72)!H0";
		
		//COG2085
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";

		//COG3715
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";
		
		//COG4964
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";
		
		//COG4965
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";
		
		//CP
		//return "(Tylochromis_intermedius,(((Oreochromis_niloticus,Sarotherodon_galilaeus)!H4,Tilapia_guineensis)!H3,(Hemichromis_fasciatus,Hemichromis_letourneuxi)!H8)!H2)!H0";
		
		//CT
		//return "(A_burtoni,((T_duboisi,(T_moorii,T_brichardi)!H5)!H3,((((P_famula,(P_fasciolatus,I_loocki)!H13)!H11,(PT_ephippium,(P_polyodon,P_macrognathus)!H18)!H16)!H10,((((G_pfefferi,C_horei)!H24,(P_curvifrons,(P_marginatus,(SP_babaulti,NP_babaulti)!H31)!H29)!H27)!H23,L_dardenni)!H22,S_diagramma)!H21)!H9,L_labiatus)!H8)!H2)!H0";
		
		//EC
		//return "(h006,((h005,h004)!H3,((h003,h002)!H7,(h001,h000)!H10)!H6)!H2)!H0";
		
		//FA
		//return "(((((Elisabethiella,Alfonsiella)!H4,Allotriozoon)!H3,Nigeriella)!H2,Courtella)!H1,(Ceratosolen,Platyscapa)!H10)!H0"; 
		
		//FD
		//return "((((h019,h018)!H3,h015)!H2,((((h016,((((h014,h013)!H15,((h008,h010)!H19,h009)!H18)!H14,((h007,h006)!H24,(h012,h005)!H27)!H23)!H13,(h017,h011)!H30)!H12)!H10,h000)!H9,h003)!H8,(h002,h001)!H35)!H7)!H1,h004)!H0";
		
		//FE
		//return "((((Formicinae,Myrmicinae)!H3,Ectatomminae)!H2,Myrmeciinae)!H1,Ponerinae)!H0";
		
		//GL
		//return "((h000,h001)!H1,(h002,(h003,(h004,(h005,(h006,h007)!H12)!H10)!H8)!H6)!H4)!H0";
		
		//GM
		//return "(((((((Allotoca_meeki,Allotoca_diazi)!H6,Allotoca_zacapuensis)!H5,Allotoca_duguesi)!H4,Neoophorus_regalis)!H3,((Zoogoneticus_purhepechus,Zoogoneticus_quitzeoensis)!H13,(Alloophorus_robustus,Chapalicthys_pardalis)!H16)!H12)!H2,(((Ilyodon_whitei,Ilyodon_furcidens)!H21,Xenotaenia_resolanae)!H20,Allodontichthys_zonistius)!H19)!H1,Characodon_audax)!H0";
	
		//IFL
		//return "(Cryptocercus_punctulatus,(((Llaveia_axin_axin_3,(Icerya_purchasi_4,Crypticerya_sp._5)!H6)!H4,Insignorthezia_insignis_23)!H3,(((Rhizoecus_gracilis,Geococcus_coffeae)!H12,(Rastrococcus_asteliae,Rastrococcus_invadens)!H15)!H11,((Parasaissetia_nigra_8,(Ceroplastes_sp._14,Coccus_viridis_24)!H21)!H19,(Cryptococcus_ulmi,(Lecanodiaspis_prosopidis_6,(Aulacaspis_sp._34,(Aonidiella_sp._40,Aonidiella_aurantii)!H30)!H28)!H26)!H24)!H18)!H10)!H2)!H0";
	
		//MF
		//return "(((((a,b)!H4,((i,h)!H8,(c,d)!H11)!H7)!H3,j)!H2,e)!H1,((f,g)!H17,k)!H16)!H0";
	
		//MP
		//return "(Manica,((formosae,(arisana,(ruginodis,rubra)!H7)!H5)!H3,((schencki,(sulcinodis,lobicornis)!H13)!H11,(rugulosa,((specioides,hellenica)!H19,(vandeli,(scabrinodis,sabuleti)!H24)!H22)!H18)!H16)!H10)!H2)!H0";
	
		//PML
		//return "(((((((h000,h001)!H6,h002)!H5,((h003,h004)!H11,h005)!H10)!H4,h006)!H3,(h007,((h008,h009)!H19,(((h010,h011)!H24,h012)!H23,h013)!H22)!H18)!H16)!H2,(h014,h015)!H29)!H1,(h016,h017)!H32)!H0";

		//PMP
		//return "((((h000,(h001,(h002,(h004,(h003,(h005,h006)!H13)!H11)!H9)!H7)!H5)!H3,(h007,((h008,h009)!H19,(((h010,h011)!H24,h012)!H23,h013)!H22)!H18)!H16)!H2,(h014,h015)!H29)!H1,(h016,h017)!H32)!H0";
	
		//PP
		//return "((((((h035,(h033,(h034,h032)!H9)!H7)!H5,(h031,h030)!H12)!H4,(h029,(h028,h027)!H17)!H15)!H3,((h026,h025)!H21,(h024,(h022,(h023,h021)!H28)!H26)!H24)!H20)!H2,((((h019,(h020,h018)!H36)!H34,(h016,(h017,h015)!H41)!H39)!H33,(h014,(h013,h012)!H46)!H44)!H32,(h011,(h010,(h009,h008)!H53)!H51)!H49)!H31)!H1,((((h007,h006)!H59,(h005,(h004,h003)!H64)!H62)!H58,(h001,h000)!H67)!H57,h002)!H56)!H0";

		//RH
		//return "(((((((h005,(h003,h004)!H8)!H6,(h013,h014)!H11)!H5,(h009,((h006,h012)!H17,(h008,(h001,((h002,h007)!H25,h000)!H24)!H22)!H20)!H16)!H14)!H4,((h018,h019)!H30,((h020,(h021,h022)!H36)!H34,h017)!H33)!H29)!H3,((h011,h010)!H41,(h015,h016)!H44)!H40)!H2,((h023,h024)!H48,((h025,h033)!H52,h026)!H51)!H47)!H1,((h032,h031)!H57,((h027,h028)!H61,(h029,h030)!H64)!H60)!H56)!H0";
		
		//RM
		//return "((R_tucanus,((R_vitellinus,R_ariel_SEBrazil)!H4,R_sulfuratus)!H3)!H1,P_inscriptus)!H0";
		
		//RP
		//return "((h000,(h001,h002)!H3)!H1,(h005,((((((h003,h006)!H13,h004)!H12,h007)!H11,h008)!H10,h012)!H9,(h009,(h010,h011)!H22)!H20)!H8)!H6)!H0";
		
		//SBL
		//return "(Spotted_Shag,((Adelie_Penguin,(Little_Blue_Penguin,(Fiordland_Crested_Penguin,Yellow-eyed_Penguin)!H7)!H5)!H3,((Royal_Albatros,Buller_Mollymawk)!H11,(((Mottled_Petrel,Cook_Petrel)!H16,(Westland_Petrel,(Sooty_Shearwather,Hutton_Shearwater)!H21)!H19)!H15,((Broad-billed_Prion,Fairy_Prion)!H25,Common_Diving_Petrel)!H24)!H14)!H10)!H2)!H0";
	
		//SC
		//return "(h000,(((h001,h002)!H4,h003)!H3,((h008,h009)!H9,((((h006,h004)!H15,h005)!H14,h007)!H13,h010)!H12)!H8)!H2)!H0";
		
		//SFC
		//return "(h014,((((h008,(h009,h001)!H7)!H5,((h006,h005)!H11,((h000,h004)!H15,h002)!H14)!H10)!H4,(h003,h007)!H19)!H3,((h012,h013)!H23,(h011,h010)!H26)!H22)!H2)!H0";
		
		//SHA
		//return "((((R_megalotis,R_mexicanus)!H3,P_boylii)!H2,((P_maniculatusG,P_maniculatusF)!H8,(P_leucopusE,P_leucopusSW)!H11)!H7)!H1,(((B_obscurus,A_azarae)!H16,((O_longicaudatus,O_chacoensis)!H20,O_palustris)!H19)!H15,(S_hispidus,S_texensis)!H24)!H14)!H0";
	
		//SSA
		//return "(((((M_sphinx,M_leucophaeus)!H4,(P_ursinus,P_cynocephalus)!H7)!H3,M_mulatta)!H2,(C_patas,C_aethiops)!H11)!H1,((H_sapiens,P_troglodytes)!H15,G_gorilla)!H14)!H0";
	
		//tahiti_araneae_coleoptera_odonata
		//return "(((coi_coleoptera_tahiti_sc02362,(coi_coleoptera_tahiti_sc02826,coi_coleoptera_tahiti_sc02824)!H4)!H2,coi_odonata_tahiti_sc02835)!H1,(((coi_araneae_tahiti_sc10314,coi_araneae_tahiti_sc10278)!H10,coi_araneae_tahiti_sc02148)!H9,(coi_araneae_tahiti_sc02721,((coi_araneae_tahiti_sc02763,(coi_araneae_tahiti_sc04248,coi_araneae_tahiti_sc04291)!H19)!H17,coi_araneae_tahiti_sc02275)!H16)!H14)!H8)!H0";
	
		//TC
		//return "((((Cottus,Dasycottus)!H3,(Neophrinichthys,Psychrolutes)!H6)!H2,(Myoxocephalus,Cottunculus)!H9)!H1,(Sebastes,Congiopodus)!H12)!H0";
		
		//TD
		//return "(((((((((T_denotata_ha_Ma,T_denotata_hb_Ma)!H8,T_swezeyi_Ma)!H7,T_swezeyi_Ka)!H6,((Ph_vittipennis_Mo,Ph_newsp_Ka)!H14,(T_crassipes_ha_Ma,T_crassipes_hb_Ma)!H17)!H13)!H5,((((T_joycei_Ma,T_joycei_Mo)!H23,T_joycei_Ka)!H22,T_waikamoi_Ma)!H21,((T_pantostica_hb_Ha,T_pantostica_ha_Ha)!H29,(T_pohakuloa_Ha,T_perkinsi_Ka)!H32)!H28)!H20)!H4,(((T_dubautiae_Ma,T_dubautiae_Oa)!H37,T_dubautiae_Ka)!H36,(((T_arboreae_ha_Ha,T_arboreae_hb_Ha)!H43,T_cratericola_Ma)!H42,T_beardsleyi_Ma)!H41)!H35)!H3,T_artemisiae_Ma)!H2,T_stellata)!H1,T_amoena)!H0";
						
		//Wolbacchia
		//return "(((((((((h056,h038)!H8,(h151,h147)!H11)!H7,((h155,((((h059,h152)!H20,h196)!H19,(h035,h034)!H24)!H18,(h058,h057)!H27)!H17)!H15,(h165,(h039,(((((h164,h163)!H38,h016)!H37,h017)!H36,(h020,(h041,h018)!H45)!H43)!H35,(h015,(h170,h169)!H50)!H48)!H34)!H32)!H30)!H14)!H6,(h194,(h005,h166)!H55)!H53)!H5,(((((((((h201,((h289,h287)!H69,(h112,((h138,h200)!H75,h143)!H74)!H72)!H68)!H66,((h382,h117)!H80,(h014,h079)!H83)!H79)!H65,((((h080,(h095,h099)!H91)!H89,((h239,h233)!H95,h189)!H94)!H88,h268)!H87,(h203,h172)!H100)!H86)!H64,h145)!H63,h046)!H62,((h088,h044)!H106,h185)!H105)!H61,((((h055,h054)!H113,h186)!H112,h184)!H111,h188)!H110)!H60,h067)!H59,(((h076,h193)!H122,((h078,h075)!H126,(((h161,h066)!H131,((h102,h131)!H135,h146)!H134)!H130,(h081,(h190,(h086,h192)!H143)!H141)!H139)!H129)!H125)!H121,(((((h010,h009)!H150,h011)!H149,h084)!H148,(((h251,h191)!H157,h048)!H156,h049)!H155)!H147,((h068,(h160,(h157,(h158,h159)!H169)!H167)!H165)!H163,((((h181,h183)!H175,h182)!H174,h053)!H173,(h036,(h154,(h156,(h149,(h153,h255)!H188)!H186)!H184)!H182)!H180)!H172)!H162)!H146)!H120)!H58)!H4,(((((((h259,((h247,h246)!H200,h087)!H199)!H197,((h341,(h335,h336)!H207)!H205,h098)!H204)!H196,((h310,((h309,h307)!H215,(((h308,h301)!H220,((h300,h305)!H224,(h303,(h304,h306)!H229)!H227)!H223)!H219,h302)!H218)!H214)!H212,h299)!H211)!H195,((((h297,h296)!H237,h000)!H236,((h019,((((((h257,h254)!H249,(((h258,h252)!H254,h253)!H253,h256)!H252)!H248,h033)!H247,((h128,h129)!H261,h134)!H260)!H246,(h008,h187)!H265)!H245,h237)!H244)!H242,(((((h320,(((h007,h104)!H277,(h262,h261)!H280)!H276,h118)!H275)!H273,(h375,((((h250,h249)!H289,h241)!H288,(h248,(h232,h231)!H295)!H293)!H287,h071)!H286)!H284)!H272,((h377,h242)!H300,h063)!H299)!H271,(((h125,(((h207,(h206,h205)!H312)!H310,h208)!H309,h235)!H308)!H306,(h106,(((((((h339,h338)!H325,h319)!H324,h234)!H323,h340)!H322,(h119,(h331,((h094,h092)!H336,h093)!H335)!H333)!H331)!H321,((h229,h228)!H341,h264)!H340)!H320,(((h298,h218)!H347,h180)!H346,(h337,(h332,h334)!H353)!H351)!H345)!H319)!H317)!H305,((((((((h322,h324)!H363,((h328,h315)!H367,h317)!H366)!H362,h318)!H361,h323)!H360,h321)!H359,h316)!H358,(h368,h333)!H375)!H357,h263)!H356)!H304)!H270,((h288,h238)!H380,((h072,(h168,h167)!H386)!H384,(h326,h325)!H389)!H383)!H379)!H269)!H241)!H235,((((h006,h004)!H395,(h002,h073)!H398)!H394,h001)!H393,(((h032,(h031,h030)!H406)!H404,h026)!H403,((h028,h365)!H411,h027)!H410)!H402)!H392)!H234)!H194,((((h116,h121)!H418,(((h107,(h123,h127)!H425)!H423,h133)!H422,(h113,h097)!H429)!H421)!H417,((((h061,h162)!H435,h148)!H434,(((h114,h105)!H441,(((h091,h367)!H446,(h343,h348)!H449)!H445,(h346,(h342,h357)!H454)!H452)!H444)!H440,h003)!H439)!H433,((h115,h380)!H459,h082)!H458)!H432)!H416,((((h062,h065)!H466,h122)!H465,(((((h378,h376)!H474,((h362,h361)!H478,h351)!H477)!H473,(((((h385,h384)!H486,h381)!H485,h359)!H484,h372)!H483,((h040,h109)!H493,((h383,h108)!H497,h103)!H496)!H492)!H482)!H472,h096)!H471,((h355,h353)!H503,(((h204,(h197,h202)!H510)!H508,((h142,h327)!H514,(h141,h140)!H517)!H513)!H507,((h363,h352)!H521,(h100,(h350,h360)!H526)!H524)!H520)!H506)!H502)!H470)!H464,(((h344,(h374,h373)!H533)!H531,(((h089,h083)!H538,(h356,h369)!H541)!H537,h260)!H536)!H530,((h060,(((((h111,h139)!H552,h120)!H551,h124)!H550,h126)!H549,h130)!H548)!H546,((h090,h050)!H560,((h137,(h136,h135)!H566)!H564,h101)!H563)!H559)!H545)!H529)!H463)!H415)!H193,((((h029,(h173,h110)!H575)!H573,(h037,(h223,h222)!H580)!H578)!H572,(h074,(h077,h132)!H585)!H583)!H571,h064)!H570)!H192,((((((((h178,h177)!H596,h266)!H595,((h227,h226)!H601,h347)!H600)!H594,h265)!H593,((h244,h245)!H607,h243)!H606)!H592,(h366,h279)!H611)!H591,h345)!H590,(((((h364,h354)!H619,((h371,h370)!H623,h069)!H622)!H618,(h330,((h070,h329)!H630,h280)!H629)!H627)!H617,(((h379,h150)!H636,h358)!H635,(((h042,h085)!H642,h349)!H641,(((h045,(h195,((h314,h313)!H653,(h043,h047)!H656)!H652)!H650)!H648,((h012,h199)!H660,h220)!H659)!H647,((((h221,(h312,h219)!H669)!H667,h216)!H666,(h217,h311)!H673)!H665,(h052,h051)!H676)!H664)!H646)!H640)!H634)!H616,h236)!H615)!H589)!H191)!H3,(((h175,(h290,h291)!H684)!H682,(((h022,(h023,h021)!H691)!H689,(h025,h024)!H694)!H688,(h144,(h294,(h292,h293)!H701)!H699)!H697)!H687)!H681,(h176,h198)!H704)!H680)!H2,(h013,h386)!H707)!H1,(((((h269,((h278,((h215,h214)!H720,h240)!H719)!H717,h174)!H716)!H714,(((((h209,h211)!H729,h212)!H728,h213)!H727,h210)!H726,h295)!H725)!H713,h171)!H712,((h271,(h272,h270)!H740)!H738,(((((h286,h283)!H747,(((h225,h285)!H752,h284)!H751,h282)!H750)!H746,h224)!H745,((((((h276,h277)!H763,h275)!H762,h274)!H761,h230)!H760,h273)!H759,h281)!H758)!H744,h267)!H743)!H737)!H711,h179)!H710)!H0";		
		
		return  "((A,B)!H1,C)!H0";
		
	}
	
	@Override
	public String getG() {
		//return "((A,C)!H1,B)!H0";
		
		//ok
		
		// 1) return "((((((((B3,A3)!P7,C3)!P6,C2)!P5,B2)!P4,A2)!P3,A1)!P2,(((A0,B0)!P17,C0)!P16,C1)!P15)!P1,B1)!P0";
		
		// 2) return "((((((((B3,A3)!P7,C3)!P6,C2)!P5,B2)!P4,A2)!P3,A1)!P2,B1)!P1,(((A0,B0)!P18,C0)!P17,C1)!P16)!P0";
		
		// 3) return "(((((((B3,A3)!P6,C3)!P5,C2)!P4,B2)!P3,A2)!P2,((((A0,B0)!P16,C0)!P15,C1)!P14,B1)!P13)!P1,A1)!P0";
		
		// 4) return "(B0,(A0,((F0,E0)!P5,(D0,C0)!P8)!P4)!P2)!P0";
		
		//AS
		//return "((((((((S_sittae,S_polioptilus)!P7,S_certhiae)!P6,S_dendroicae_A)!P5,S_dendroicae_B)!P4,S_sp_D)!P3,(S_sp_F,(S_sp_E,S_elongatus)!P16)!P14)!P2,(S_passerinae,(S_sp_C,(S_tyranni_A,S_tyranni_B)!P23)!P21)!P19)!P1,(S_empidonax,(S_turdus,S_sialiae)!P28)!P26)!P0";
		
		//CA
		//return "(((((((a_karii,(a_turfusa,(a_bigelowii,a_pratensis)!P10)!P8)!P6,((((a_hostianae,a_buxbaumii)!P16,a_lasiocarpae)!P15,a_caricis-meadii)!P14,a_paniceae)!P13)!P5,a_misandrae)!P4,(((a_inclusa,a_subinclusa)!P25,a_heterospora)!P24,a_sempervirentis)!P23)!P3,a_limosa)!P2,((a_aspera,a_arenaria)!P49,a_sp1)!P48)!P1,((a_elynae,a_curvulae)!P54,a_sclerotiformis)!P53)!P0";
	
		//COG2085
		//return "((((9598.01,9606.01)!P3,10090.02)!P2,((7955.02,7955.01)!P8,(10090.01,(((100226.06,(((188937.01,(224325.02,224325.01)!P21)!P19,64091.01)!P18,(187420.01,(190192.01,243232.01)!P27)!P25)!P17)!P15,251221.01)!P14,((((272623.01,(220668.03,196627.02)!P36)!P34,(100226.05,100226.04)!P39)!P33,267608.01)!P32,((((204669.01,189518.01)!P46,103690.01)!P45,234267.02)!P44,(((160492.01,266835.03)!P53,100226.03)!P52,((220668.02,196627.01)!P58,((((100226.02,190485.01)!P64,266835.02)!P63,100226.01)!P62,(220668.01,(176299.01,(266834.01,(266835.01,(234267.01,224911.01)!P77)!P75)!P73)!P71)!P69)!P61)!P57)!P51)!P43)!P31)!P13)!P11)!P7)!P1,(7955.03,((9606.02,9598.02)!P83,10090.03)!P82)!P80)!P0";

	
		//COG3715
		//return "((221109.01,(((272626.03,226185.13)!P5,170187.04)!P4,(272623.01,((((187410.02,(209261.02,(83333.02,198214.04)!P18)!P16)!P14,272626.04)!P13,(198214.03,224308.01)!P22)!P12,(170187.03,(((((273068.01,226185.12)!P31,(226185.11,209261.01)!P34)!P30,226185.10)!P29,(226185.09,(272626.02,(((170187.02,226185.08)!P44,226185.07)!P43,226185.06)!P42)!P40)!P38)!P28,((((226185.05,(190304.01,226185.04)!P54)!P52,272626.01)!P51,226185.03)!P50,((74109.02,187410.01)!P60,(((74109.01,198214.02)!P65,226185.02)!P64,((226185.01,170187.01)!P70,(220668.01,(198214.01,83333.01)!P75)!P73)!P69)!P63)!P59)!P49)!P27)!P25)!P11)!P9)!P3)!P1,220668.02)!P0";
	
		//COG4964
		//return "(((((266834.02,176299.01)!P4,266835.03)!P3,((224911.03,224911.02)!P9,258594.01)!P8)!P2,((74109.01,(266835.04,224911.04)!P16)!P14,((266835.02,((266834.01,266835.01)!P23,224911.01)!P22)!P20,((882.01,(194439.01,267608.02)!P30)!P28,(((520.02,267608.01)!P35,208964.01)!P34,((959.01,(234267.02,234267.01)!P42)!P40,(520.01,(117.01,(243230.01,262724.01)!P49)!P47)!P45)!P39)!P33)!P27)!P19)!P13)!P1,190650.01)!P0";
	
		//COG4965
		//return "((266834.01,(190650.01,((224911.01,117.02)!P6,(((882.01,((234267.02,234267.01)!P14,194439.01)!P13)!P11,74109.02)!P10,(((117.03,267608.02)!P21,234267.03)!P20,((266835.02,266835.01)!P26,((((959.01,117.01)!P32,520.02)!P31,100226.01)!P30,(((74109.01,187410.01)!P39,(83331.01,196627.01)!P42)!P38,(208964.01,(520.01,267608.01)!P47)!P45)!P37)!P29)!P25)!P19)!P9)!P5)!P3)!P1,(((266834.02,176299.01)!P52,266835.03)!P51,(258594.01,224911.02)!P56)!P50)!P0";
		
		//CP
		//return "(((((((Cichlidogyrus_halli2,Cichlidogyrus_halli1)!P6,((Cichlidogyrus_tiberianus,Cichlidogyrus_cubitus)!P10,((Cichlidogyrus_douellouae,Cichlidogyrus_ergensi)!P14,((((Cichlidogyrus_agnesi,Cichlidogyrus_gallus)!P20,Cichlidogyrus_flexicolpos)!P19,(Cichlidogyrus_thurstonae,Cichlidogyrus_bilongi)!P24)!P18,Cichlidogyrus_aegypticus)!P17)!P13)!P9)!P5,(((Cichlidogyrus_cirratus,Cichlidogyrus_njinei)!P30,(Cichlidogyrus_acerbus,Cichlidogyrus_sp2)!P33)!P29,(((Cichlidogyrus_digitatus,Cichlidogyrus_arthracanthus)!P38,Cichlidogyrus_yanni)!P37,(((Scutogyrus_longicornis,Scutogyrus_bailloni)!P44,Scutogyrus_minus)!P43,Cichlidogyrus_tilapiae)!P42)!P36)!P28)!P4,((Cichlidogyrus_longicirrus,Cichlidogyrus_sp1)!P50,Cichlidogyrus_falcifer)!P49)!P3,Cichlidogyrus_amphoratus)!P2,Cichlidogyrus_sclerosus)!P1,Cichlidogyrus_pouyaudi)!P0";
		
		//CT
		//return "((((((P_fasciolatus-001,I_loocki-001)!P5,(P_polyodon-003,P_macrognathus-002)!P8)!P4,PT_ephippium-001)!P3,(((((L_dardenni-001,S_diagramma-001)!P16,G_pfefferi-001)!P15,(SP_babaulti-001,(C_horei-001,(P_curvifrons-001,(NP_babaulti-001,P_marginatus-001)!P26)!P24)!P22)!P20)!P14,((T_duboisi-001,T_brichardi-001)!P30,T_moorii-001)!P29)!P13,L_labiatus-001)!P12)!P2,P_famula-001)!P1,A_burtoni-001)!P0";
	
		//EC
		//return "((((h000-001,(((h000-002,h001-002)!P7,h001-001)!P6,(h002-002,(h002-001,h003-001)!P13)!P11)!P5)!P3,h004-001)!P2,h005-001)!P1,h006-001)!P0";
		
		//FA
		//return "((((Chlamydodorae1,Platyphylla)!P3,Caulocarpae)!P2,((Chlamydodorae2,Crassicostae)!P8,Galoglychia)!P7)!P1,(Sycomorus,Urostigma)!P12)!P0"; 
		
		//FD
		//return "((((h000-001,(h001-001,h002-001)!P5)!P3,h003-001)!P2,((h004-002,h004-001)!P10,(((((h005-003,h006-001)!P17,h007-001)!P16,((((h008-002,(h009-005,h009-003)!P26)!P24,(h010-002,h010-003)!P29)!P23,(((h008-005,h011-001)!P34,(h012-002,(h012-001,h012-003)!P39)!P37)!P33,(((((h013-001,(h013-004,h013-003)!P48)!P46,(h008-003,(h014-002,(h014-001,h014-003)!P55)!P53)!P51)!P45,(h008-001,h008-004)!P58)!P44,h015-001)!P43,(h015-003,h015-002)!P62)!P42)!P32)!P22,(h016-001,h007-002)!P65)!P21)!P15,(h017-001,(h005-001,((h009-006,h005-002)!P73,(h011-002,h009-002)!P76)!P72)!P70)!P68)!P14,(h010-001,(h009-001,(h013-002,h009-004)!P83)!P81)!P79)!P13)!P9)!P1,(((h018-006,h018-005)!P88,(h018-003,h018-001)!P91)!P87,((h018-004,h018-002)!P95,(h019-001,h019-002)!P98)!P94)!P86)!P0";
	
		//FE
		//return "((((formicine_parasitoids,PEM_parasitoids)!P3,Psilocharitini)!P2,Oraseminae)!P1,Gollumiellinae)!P0";
		
		//GL
		//return "((h000-002,h001-002)!P1,((h000-001,(h001-001,h002-001)!P7)!P5,(h003-001,((h004-001,h005-001)!P13,(h006-001,h007-001)!P16)!P12)!P10)!P4)!P0";
	
		//GM
		//return "((((((((La_Luz_Spring,Mintzita_Spring)!P7,Rico_Spring)!P6,Chapultepec_Spring)!P5,Zacapu_Lake)!P4,Opopeo_Lake)!P3,(((Abraham_Gonzalez_Spring,Guadalupe_Aguilera_Spring)!P16,El_Toboso_Spring)!P15,Pino_Suarez_Spring)!P14)!P2,((Tlapetlahuaya_Spring,Tocumbo_Spring)!P22,Ahuacapan_Spring)!P21)!P1,Margotrema_resolanae)!P0";
		
		//IFL
		//return "((((F_Aonidiella_sp._40,F_Aonidiella_aurantii)!P3,F_Aulacaspis_sp._34)!P2,((F_Rastrococcus_asteliae,F_Rastrococcus_invadens)!P8,(F_Cryptococcus_ulmi,((F_Ceroplastes_sp._14,F_Coccus_viridis_24)!P14,(F_Insignorthezia_insignis_23,(F_Parasaissetia_nigra_8,(F_Lecanodiaspis_prosopidis_6,((F_Icerya_purchasi_4,F_Crypticerya_sp._5)!P24,F_Llaveia_axin_axin_3)!P23)!P21)!P19)!P17)!P13)!P11)!P7)!P1,((F_Rhizoecus_gracilis,F_Geococcus_coffeae)!P29,F_Cryptocercus_punctulatus)!P28)!P0";
		
		//MF
		//return "((((1,3)!P3,2)!P2,(4,5)!P7)!P1,((7,8)!P11,(6,9)!P14)!P10)!P0";
		
		//MP
		//return "(Phengaris_daitozana,(Phengaris_atroguttata,((alcon,rebeli)!P5,((arion,arionides)!P9,(teleius,nausithous)!P12)!P8)!P4)!P2)!P0";
		
		//PML
		//return "((((h000-001,(h001-001,((h002-001,h003-001)!P8,(h004-001,h005-001)!P11)!P7)!P5)!P3,(h006-001,h007-001)!P14)!P2,((h008-001,h009-001)!P18,((h010-001,(h011-001,(h012-001,h013-001)!P26)!P24)!P22,(h014-001,h015-001)!P29)!P21)!P17)!P1,(h016-001,h017-001)!P32)!P0";
	
		//PMP
		//return "((((((h000-001,(h001-001,((h002-001,h003-001)!P10,(h004-001,(h005-001,h006-001)!P15)!P13)!P9)!P7)!P5,h007-001)!P4,(h008-001,h009-001)!P19)!P3,(h010-001,(h011-001,(h012-001,h013-001)!P26)!P24)!P22)!P2,(h014-001,h015-001)!P29)!P1,(h016-001,h017-001)!P32)!P0";
		
		//PP
		//return "(((h000-001,h001-001)!P2,(h002-001,(((((h003-002,h003-001)!P11,h004-001)!P10,h005-001)!P9,h006-001)!P8,h007-001)!P7)!P5)!P1,(((((h008-002,h008-001)!P22,h009-001)!P21,(h010-001,(h011-001,(h012-001,(h013-001,h014-001)!P32)!P30)!P28)!P26)!P20,((((h015-001,h016-002)!P38,h016-001)!P37,h017-001)!P36,((((h018-001,h018-002)!P46,h019-001)!P45,h020-002)!P44,h020-001)!P43)!P35)!P19,(((((((h021-001,h022-001)!P58,h023-001)!P57,h024-001)!P56,(h025-001,h026-001)!P63)!P55,(h027-001,h028-001)!P66)!P54,h029-001)!P53,((h030-001,h031-001)!P71,(h032-001,(h033-001,(h034-001,h035-001)!P78)!P76)!P74)!P70)!P52)!P18)!P0";
	
		//RH
		//return "((((((((((h000-002,h000-001)!P9,((h001-002,h001-001)!P13,h002-001)!P12)!P8,((h003-001,h004-001)!P18,h005-001)!P17)!P7,(((h006-001,h007-001)!P24,h008-001)!P23,h009-001)!P22)!P6,((h010-001,(h010-002,(h011-002,h011-001)!P34)!P32)!P30,h010-003)!P29)!P5,((h012-001,h013-002)!P39,h013-001)!P38)!P4,(h014-001,(h015-001,h016-001)!P45)!P43)!P3,((h017-001,(h018-001,h019-001)!P51)!P49,(h020-001,(h021-001,h022-001)!P56)!P54)!P48)!P2,((((h023-001,h024-004)!P62,(h024-002,(h024-001,h024-003)!P67)!P65)!P61,(h025-001,h026-001)!P70)!P60,((((h027-001,h028-001)!P76,h029-001)!P75,h030-001)!P74,h031-001)!P73)!P59)!P1,h032-001)!P0";
	
		//RM
		//return "((((A_cancellosus4,A_cancellosus5)!P3,A_cancellosus6)!P2,A_cancellosus1)!P1,A_cancellosus3)!P0";
	
		//RP
		//return "((((h000-001,(h001-001,h002-001)!P5)!P3,h003-001)!P2,h004-001)!P1,(h005-001,(((((h006-001,h007-001)!P16,h008-001)!P15,(h009-001,h010-001)!P20)!P14,h011-001)!P13,h012-001)!P12)!P10)!P0";
	
		//SBL
		//return "(Pectinopygus,(Docophoroides,((Austrogonoides,Episbates)!P5,(((Naubates,Harrisoniella)!P10,Pelmatocerandra)!P9,Trabeculus)!P8)!P4)!P2)!P0";
	
		//SC
		//return "(h000-001,(((h001-001,h002-001)!P4,h003-001)!P3,(((h004-001,h005-001)!P10,(h006-002,h007-002)!P13)!P9,(h008-001,(((h009-001,(h006-001,h004-002)!P22)!P20,h010-001)!P19,h007-001)!P18)!P16)!P8)!P2)!P0";
	
		//SFC
		//return "(h000-001,(h001-001,((h002-002,h003-001)!P5,((h004-001,(((h005-001,h006-001)!P13,(h007-001,(h008-001,h002-001)!P18)!P16)!P12,h009-001)!P11)!P9,((((h010-001,h011-001)!P25,h012-001)!P24,h013-001)!P23,h014-001)!P22)!P8)!P4)!P2)!P0";
	
	
		//SHA
		//return "(((((MUL,BCC)!P4,BAY)!P3,(((BMJ,ORN)!P10,AND)!P9,(PER,MAC)!P14)!P8)!P2,((BRI,BRO)!P18,(SNV,(MON,NYV)!P23)!P21)!P17)!P1,(LSC,(RIOS,EMC)!P28)!P26)!P0";
	
		//SSA
		//return "((((((MISV,MsSV)!P5,(PuSV,PcSV)!P8)!P4,CpSV)!P3,CaSV)!P2,MmSV)!P1,(GgSV,(HsSV,PtSV)!P16)!P14)!P0";
		
		//tahiti_araneae_coleoptera_odonata
		//return "((((((((fbpa_araneae_tahiti_sc04291,((fbpa_araneae_tahiti_sc10278,fbpa_araneae_tahiti_sc04248)!P10,fbpa_araneae_tahiti_sc02721)!P9)!P7,fbpa_araneae_tahiti_sc10314)!P6,fbpa_araneae_tahiti_sc02275)!P5,fbpa_araneae_tahiti_sc02763)!P4,(fbpa_coleoptera_tahiti_sc02826,fbpa_coleoptera_tahiti_sc02824)!P17)!P3,fbpa_araneae_tahiti_sc02148)!P2,fbpa_odonata_tahiti_sc02835)!P1,fbpa_coleoptera_tahiti_sc02362)!P0";
	
		//TC
		//return "(((((C_yanezi,C_cotunculi)!P4,C_triventricosus)!P3,(((C_pinguis,C_multituberculatus)!P10,C_irregularis)!P9,C_tuberculatus)!P8)!P2,C_nodosus)!P1,C_distortus)!P0";
	
		//TD
		//return "((((((((1,2)!P7,(3,4)!P10)!P6,(5,6)!P13)!P5,(7,(8,9)!P18)!P16)!P4,(10,11)!P21)!P3,(((12,13)!P26,14)!P25,(15,(16,17)!P32)!P30)!P24)!P2,(18,(19,20)!P37)!P35)!P1,(21,22)!P40)!P0";
				
		//Wolbacchia
		//return "(h386-001,((((((((((((((((h385-001,(((((h384-001,h383-001)!P23,h382-001)!P22,h381-001)!P21,h380-001)!P20,(h379-001,(h378-001,(h377-001,((h376-001,h375-001)!P36,(h374-001,(h373-001,(h372-001,(h371-001,((h370-001,h369-001)!P48,(h368-001,(h367-001,(h366-001,(h365-001,(h364-001,(h363-001,(h362-001,(((((((h361-001,(h360-001,h359-001)!P73)!P71,h358-001)!P70,h357-001)!P69,h356-001)!P68,h355-001)!P67,h354-001)!P66,(h353-001,(h352-001,(h351-001,(h350-001,(h349-001,(h348-001,(h347-001,(h346-001,h345-001)!P95)!P93)!P91)!P89)!P87)!P85)!P83)!P81)!P65)!P63)!P61)!P59)!P57)!P55)!P53)!P51)!P47)!P45)!P43)!P41)!P39)!P35)!P33)!P31)!P29)!P19)!P17,h344-001)!P16,h343-001)!P15,h342-001)!P14,h341-001)!P13,h340-001)!P12,(((h339-001,((h338-001,(((((h337-001,h336-001)!P114,h335-001)!P113,h334-001)!P112,h333-001)!P111,h332-001)!P110)!P108,h331-001)!P107)!P105,(h330-001,h329-001)!P122)!P104,(((((((((((((h328-001,(h327-001,h326-001)!P139)!P137,h325-001)!P136,h324-001)!P135,h323-001)!P134,h322-001)!P133,h321-001)!P132,h320-001)!P131,h319-001)!P130,h318-001)!P129,h317-001)!P128,h316-001)!P127,h315-001)!P126,(h314-001,h313-001)!P153)!P125)!P103)!P11,((((h312-001,h311-001)!P159,((((((h310-001,(h309-001,(h308-001,(((((((h307-001,h306-001)!P179,h305-001)!P178,h304-001)!P177,h303-001)!P176,h302-001)!P175,h301-001)!P174,h300-001)!P173)!P171)!P169)!P167,(h299-001,h298-001)!P188)!P166,(h297-001,h296-001)!P191)!P165,h295-001)!P164,(((((h294-001,h293-001)!P199,h292-001)!P198,(h291-001,h290-001)!P203)!P197,((((h289-001,h288-001)!P209,h287-001)!P208,((((h286-001,h285-001)!P216,h284-001)!P215,(((h283-001,h282-001)!P222,(h281-001,h280-001)!P225)!P221,h279-001)!P220)!P214,(((h278-001,h277-001)!P231,((h276-001,h275-001)!P235,(h274-001,h273-001)!P238)!P234)!P230,(h272-001,(h271-001,h270-001)!P243)!P241)!P229)!P213)!P207,h269-001)!P206)!P196,(((h268-001,h267-001)!P249,((h266-001,h265-001)!P253,h264-001)!P252)!P248,((((h263-001,(h262-001,h261-001)!P262)!P260,h260-001)!P259,h259-001)!P258,((h258-001,(h257-001,(((h256-001,h255-001)!P274,h254-001)!P273,h253-001)!P272)!P270)!P268,h252-001)!P267)!P257)!P247)!P195)!P163,h251-001)!P162)!P158,((h250-001,(h249-001,(h248-001,((((((h247-001,h246-001)!P293,h245-001)!P292,(h244-001,h243-001)!P297)!P291,h242-001)!P290,h241-001)!P289,h240-001)!P288)!P286)!P284)!P282,(((((((((h239-001,h238-001)!P311,h237-001)!P310,h236-001)!P309,h235-001)!P308,h234-001)!P307,h233-001)!P306,((h232-001,h231-001)!P320,h230-001)!P319)!P305,(h229-001,h228-001)!P324)!P304,(h227-001,h226-001)!P327)!P303)!P281)!P157,h225-001)!P156)!P10,h224-001)!P9,((h223-001,h222-001)!P333,((h221-001,h220-001)!P337,(((h219-001,h218-001)!P342,h217-001)!P341,h216-001)!P340)!P336)!P332)!P8,((((((h215-001,h214-001)!P352,h213-001)!P351,h212-001)!P350,h211-001)!P349,h210-001)!P348,h209-001)!P347)!P7,((((h208-001,(h207-001,(h206-001,h205-001)!P367)!P365)!P363,((((((((h204-001,(h203-001,h202-001)!P379)!P377,h201-001)!P376,h200-001)!P375,h199-001)!P374,h198-001)!P373,h197-001)!P372,h196-001)!P371,h195-001)!P370)!P362,h194-001)!P361,((h193-001,((h192-001,h191-001)!P394,h190-001)!P393)!P391,(h189-001,(h188-001,(((h187-001,h186-001)!P404,h185-001)!P403,h184-001)!P402)!P400)!P398)!P390)!P360)!P6,((h183-001,h182-001)!P410,h181-001)!P409)!P5,(((((h180-001,h179-001)!P418,((((h178-001,h177-001)!P424,h176-001)!P423,h175-001)!P422,h174-001)!P421)!P417,(h173-001,h172-001)!P430)!P416,(h171-001,(h170-001,h169-001)!P435)!P433)!P415,((((((h168-001,h167-001)!P443,h166-001)!P442,h165-001)!P441,((h164-001,(h163-001,h162-001)!P451)!P449,(h161-001,(((h160-001,h159-001)!P458,h158-001)!P457,h157-001)!P456)!P454)!P448)!P440,((h156-001,(h155-001,(h154-001,(h153-001,(h152-001,((((h151-001,h150-001)!P477,h149-001)!P476,h148-001)!P475,h147-001)!P474)!P472)!P470)!P468)!P466)!P464,((((h146-001,(h145-001,h144-001)!P488)!P486,(((((((((h143-001,(h142-001,(((((((((((((((((((h141-001,h140-001)!P521,(h139-001,h138-001)!P524)!P520,(h137-001,(h136-001,h135-001)!P529)!P527)!P519,h134-001)!P518,h133-001)!P517,h132-001)!P516,h131-001)!P515,h130-001)!P514,h129-001)!P513,h128-001)!P512,h127-001)!P511,h126-001)!P510,h125-001)!P509,h124-001)!P508,h123-001)!P507,h122-001)!P506,h121-001)!P505,h120-001)!P504,(h119-001,(h118-001,(h117-001,(h116-001,(h115-001,(h114-001,(h113-001,(h112-001,(h111-001,(h110-001,(h109-001,(h108-001,(h107-001,(h106-001,(h105-001,(h104-001,(h103-001,(h102-001,(h101-001,(h100-001,(h099-001,(h098-001,(h097-001,h096-001)!P591)!P589)!P587)!P585)!P583)!P581)!P579)!P577)!P575)!P573)!P571)!P569)!P567)!P565)!P563)!P561)!P559)!P557)!P555)!P553)!P551)!P549)!P547)!P503)!P501)!P499,h095-001)!P498,(h094-001,(h093-001,h092-001)!P597)!P595)!P497,((((h091-001,(h090-001,(h089-001,(h088-001,(h087-001,(h086-001,(h085-001,(((h084-001,h083-001)!P619,h082-001)!P618,h081-001)!P617)!P615)!P613)!P611)!P609)!P607)!P605)!P603,h080-001)!P602,h079-001)!P601,(((h078-001,((((h077-001,h076-001)!P633,h075-001)!P632,h074-001)!P631,h073-001)!P630)!P628,(h072-001,h071-001)!P639)!P627,h070-001)!P626)!P600)!P496,h069-001)!P495,h068-001)!P494,h067-001)!P493,h066-001)!P492,(h065-001,(h064-001,h063-001)!P649)!P647)!P491)!P485,((((((h062-001,(h061-001,(h060-001,((((((((((((((h059-001,(h058-001,(h057-001,h056-001)!P680)!P678)!P676,((h055-001,(h054-001,h053-001)!P686)!P684,(h052-001,h051-001)!P689)!P683)!P675,h050-001)!P674,h049-001)!P673,h048-001)!P672,h047-001)!P671,h046-001)!P670,h045-001)!P669,h044-001)!P668,h043-001)!P667,h042-001)!P666,h041-001)!P665,h040-001)!P664,h039-001)!P663)!P661)!P659)!P657,h038-001)!P656,h037-001)!P655,h036-001)!P654,(h035-001,(h034-001,h033-001)!P709)!P707)!P653,((((h032-001,(h031-001,(h030-001,h029-001)!P719)!P717)!P715,h028-001)!P714,h027-001)!P713,h026-001)!P712)!P652)!P484,((h025-001,h024-001)!P726,((h023-001,h022-001)!P730,h021-001)!P729)!P725)!P483)!P463)!P439,((((((h020-001,h019-001)!P739,h018-001)!P738,h017-001)!P737,h016-001)!P736,h015-001)!P735,h014-001)!P734)!P438)!P414)!P4,(h013-001,(h012-001,(h011-001,(h010-001,h009-001)!P753)!P751)!P749)!P747)!P3,(((h008-001,h007-001)!P758,((h006-001,(h005-001,(h004-001,(h003-001,h002-001)!P768)!P766)!P764)!P762,h001-001)!P761)!P757,h000-001)!P756)!P2)!P0";
		
		return  "((A,B)!H1,C)!H0";
	
	}


	

	@Override
	public HashMap<String, String> getMapping() {
		String mapping="";
		
		//AS
		//mapping=" S_certhiae=Brown_Creeper, S_sp_C=B_headed_Grosbeak, S_turdus=American_Robin, S_dendroicae_B=Grace_Warbler, S_dendroicae_A=Grace_Warbler, S_tyranni_B=Ash_throated_Flycatcher, S_empidonax=Gray_Flycatcher, S_sp_D=Chipping_Sparrow, S_polioptilus=Bg_Gnatcatcher, S_sittae=W_breasted_Nuthatch, S_elongatus=Brewer_Blackbird, S_sialiae=Western_Bluebird, S_sp_F=Bullock_Oriole, S_sp_E=Y_headed_Blackbird, S_tyranni_A=Western_Kingbird, S_passerinae=Indigo_Bunting";
		
		//CA
		//mapping=" a_bigelowii=c_bigelowii, a_inclusa=c_rostrata, a_elynae=k_myosuroides, a_sp1=c_davalliana, a_limosa=c_limosa, a_hostianae=c_hostiana, a_pratensis=c_flacca, a_curvulae=c_curvula, a_heterospora=c_elata, a_sempervirentis=c_ferruginea, a_buxbaumii=c_buxbaumii, a_turfusa=c_heleonastes, a_karii=c_echinata, a_paniceae=c_meadii, a_aspera=c_chordorrhiza, a_lasiocarpae=c_lasiocarpa, a_arenaria=c_arenaria, a_caricis-meadii=c_panicea, a_subinclusa=c_vesicaria, a_sclerotiformis=u_rubra, a_misandrae=c_atrofusca";
		
		//COG2085
		//mapping=" 10090.02=10090, 64091.01=64091, 100226.03=100226, 196627.02=196627, 266834.01=266834, 224911.01=224911, 251221.01=251221, 190485.01=190485, 204669.01=204669, 100226.01=100226, 100226.04=100226, 220668.01=220668, 234267.01=234267, 176299.01=176299, 10090.01=10090, 9598.01=9598, 196627.01=196627, 103690.01=103690, 7955.03=7955, 10090.03=10090, 220668.03=220668, 9598.02=9598, 188937.01=188937, 267608.01=267608, 100226.02=100226, 100226.05=100226, 266835.03=266835, 7955.01=7955, 9606.02=9606, 7955.02=7955, 190192.01=190192, 243232.01=243232, 160492.01=160492, 9606.01=9606, 189518.01=189518, 224325.02=224325, 272623.01=272623, 100226.06=100226, 234267.02=234267, 266835.02=266835, 266835.01=266835, 187420.01=187420, 220668.02=220668, 224325.01=224325";
		
		//COG3715
		//mapping=" 226185.13=226185, 198214.03=198214, 272626.01=272626, 226185.10=226185, 220668.01=220668, 220668.02=220668, 226185.12=226185, 74109.01=74109, 226185.08=226185, 226185.02=226185, 272626.02=272626, 226185.01=226185, 83333.01=83333, 170187.01=170187, 187410.02=187410, 221109.01=221109, 74109.02=74109, 226185.06=226185, 209261.01=209261, 83333.02=83333, 170187.02=170187, 187410.01=187410, 226185.09=226185, 226185.04=226185, 272623.01=272623, 170187.04=170187, 170187.03=170187, 273068.01=273068, 190304.01=190304, 272626.03=272626, 226185.07=226185, 198214.04=198214, 226185.11=226185, 209261.02=209261, 226185.05=226185, 198214.02=198214, 198214.01=198214, 224308.01=224308, 226185.03=226185, 272626.04=272626";

		//COG4964
		//mapping=" 266835.03=266835, 266834.01=266834, 267608.01=267608, 194439.01=194439, 234267.01=234267, 959.01=959, 258594.01=258594, 266834.02=266834, 117.01=117, 520.02=520, 266835.04=266835, 234267.02=234267, 208964.01=208964, 190650.01=190650, 224911.02=224911, 224911.03=224911, 224911.01=224911, 882.01=882, 262724.01=262724, 176299.01=176299, 520.01=520, 224911.04=224911, 267608.02=267608, 74109.01=74109, 243230.01=243230, 266835.01=266835, 266835.02=266835";
		
		//COG4965
		//mapping=" 224911.01=224911, 267608.02=267608, 266835.03=266835, 100226.01=100226, 959.01=959, 196627.01=196627, 187410.01=187410, 234267.02=234267, 266834.01=266834, 224911.02=224911, 520.01=520, 520.02=520, 194439.01=194439, 83331.01=83331, 74109.01=74109, 176299.01=176299, 882.01=882, 117.02=117, 266835.02=266835, 266835.01=266835, 266834.02=266834, 190650.01=190650, 208964.01=208964, 74109.02=74109, 117.01=117, 234267.01=234267, 267608.01=267608, 234267.03=234267, 258594.01=258594, 117.03=117";
		
		//CP
		//mapping=" Cichlidogyrus_tiberianus=Tilapia_guineensis, Cichlidogyrus_bilongi=Tilapia_guineensis, Cichlidogyrus_sclerosus=Oreochromis_niloticus, Cichlidogyrus_arthracanthus=Tilapia_guineensis, Cichlidogyrus_acerbus=Sarotherodon_galilaeus, Scutogyrus_minus=Oreochromis_niloticus, Scutogyrus_longicornis=Oreochromis_niloticus, Cichlidogyrus_ergensi=Tilapia_guineensis, Cichlidogyrus_halli2=Oreochromis_niloticus, Cichlidogyrus_longicirrus=Hemichromis_fasciatus, Cichlidogyrus_digitatus=Tilapia_guineensis, Cichlidogyrus_gallus=Tilapia_guineensis, Scutogyrus_bailloni=Sarotherodon_galilaeus, Cichlidogyrus_yanni=Tilapia_guineensis, Cichlidogyrus_amphoratus=Tilapia_guineensis, Cichlidogyrus_douellouae=Sarotherodon_galilaeus, Cichlidogyrus_cubitus=Tilapia_guineensis, Cichlidogyrus_cirratus=Oreochromis_niloticus, Cichlidogyrus_njinei=Sarotherodon_galilaeus, Cichlidogyrus_falcifer=Hemichromis_fasciatus, Cichlidogyrus_halli1=Sarotherodon_galilaeus, Cichlidogyrus_tilapiae=Oreochromis_niloticus, Cichlidogyrus_flexicolpos=Tilapia_guineensis, Cichlidogyrus_sp2=Sarotherodon_galilaeus, Cichlidogyrus_agnesi=Tilapia_guineensis, Cichlidogyrus_sp1=Hemichromis_letourneuxi, Cichlidogyrus_aegypticus=Tilapia_guineensis, Cichlidogyrus_pouyaudi=Tylochromis_intermedius, Cichlidogyrus_thurstonae=Oreochromis_niloticus";
		
		
		//CT
		//mapping=" P_polyodon-003=P_polyodon, P_curvifrons-001=P_curvifrons, A_burtoni-001=A_burtoni, P_famula-001=P_famula, T_brichardi-001=T_brichardi, PT_ephippium-001=PT_ephippium, P_macrognathus-002=P_macrognathus, P_marginatus-001=P_marginatus, T_duboisi-001=T_duboisi, L_dardenni-001=L_dardenni, I_loocki-001=I_loocki, P_fasciolatus-001=P_fasciolatus, SP_babaulti-001=SP_babaulti, T_moorii-001=T_moorii, S_diagramma-001=S_diagramma, L_labiatus-001=L_labiatus, G_pfefferi-001=G_pfefferi, NP_babaulti-001=NP_babaulti, C_horei-001=C_horei";
		
		//EC
		//mapping=" h002-001=h002, h000-002=h000, h001-002=h001, h000-001=h000, h005-001=h005, h003-001=h003, h002-002=h002, h001-001=h001, h004-001=h004, h006-001=h006";
		
		//FA
		//mapping=" Galoglychia=Allotriozoon, Platyphylla=Nigeriella, Caulocarpae=Courtella, Chlamydodorae1=Alfonsiella, Sycomorus=Ceratosolen, Crassicostae=Elisabethiella, Chlamydodorae2=Elisabethiella, Urostigma=Platyscapa";
		
		//FD
		//mapping=" h002-001=h002, h009-005=h009, h012-001=h012, h005-002=h005, h010-001=h010, h016-001=h016, h013-003=h013, h013-001=h013, h009-002=h009, h009-006=h009, h004-001=h004, h000-001=h000, h015-003=h015, h018-006=h018, h012-002=h012, h006-001=h006, h015-002=h015, h018-004=h018, h012-003=h012, h008-001=h008, h004-002=h004, h013-002=h013, h010-002=h010, h014-003=h014, h008-003=h008, h007-001=h007, h011-001=h011, h005-003=h005, h008-004=h008, h008-005=h008, h017-001=h017, h005-001=h005, h018-003=h018, h014-002=h014, h009-001=h009, h009-004=h009, h013-004=h013, h019-002=h019, h018-005=h018, h003-001=h003, h010-003=h010, h001-001=h001, h018-001=h018, h019-001=h019, h018-002=h018, h014-001=h014, h007-002=h007, h011-002=h011, h009-003=h009, h015-001=h015, h008-002=h008";
		
		//FE
		//mapping=" PEM_parasitoids=Ectatomminae, Psilocharitini=Ponerinae, formicine_parasitoids=Formicinae, Gollumiellinae=Formicinae, Oraseminae=Myrmeciinae";
		
		//GL
		//mapping=" h003-001=h003, h001-002=h001, h000-001=h000, h000-002=h000, h006-001=h006, h004-001=h004, h002-001=h002, h001-001=h001, h005-001=h005, h007-001=h007";
		
		//GM
		//mapping=" Rico_Spring=Neoophorus_regalis, Tlapetlahuaya_Spring=Ilyodon_whitei, Zacapu_Lake=Allotoca_zacapuensis, Chapultepec_Spring=Allotoca_diazi, Ahuacapan_Spring=Allodontichthys_zonistius, Margotrema_resolanae=Xenotaenia_resolanae, Opopeo_Lake=Allotoca_meeki, Mintzita_Spring=Zoogoneticus_quitzeoensis, La_Luz_Spring=Zoogoneticus_purhepechus, El_Toboso_Spring=Characodon_audax, Abraham_Gonzalez_Spring=Characodon_audax, Guadalupe_Aguilera_Spring=Characodon_audax, Tocumbo_Spring=Chapalicthys_pardalis, Pino_Suarez_Spring=Characodon_audax";
		
		//IFL
		//mapping=" F_Aulacaspis_sp._34=Aulacaspis_sp._34, F_Lecanodiaspis_prosopidis_6=Lecanodiaspis_prosopidis_6, F_Rhizoecus_gracilis=Rhizoecus_gracilis, F_Rastrococcus_invadens=Rastrococcus_invadens, F_Rastrococcus_asteliae=Rastrococcus_asteliae, F_Crypticerya_sp._5=Crypticerya_sp._5, F_Llaveia_axin_axin_3=Llaveia_axin_axin_3, F_Cryptococcus_ulmi=Cryptococcus_ulmi, F_Aonidiella_aurantii=Aonidiella_aurantii, F_Aonidiella_sp._40=Aonidiella_sp._40, F_Insignorthezia_insignis_23=Insignorthezia_insignis_23, F_Geococcus_coffeae=Geococcus_coffeae, F_Ceroplastes_sp._14=Ceroplastes_sp._14, F_Cryptocercus_punctulatus=Cryptocercus_punctulatus, F_Coccus_viridis_24=Coccus_viridis_24, F_Icerya_purchasi_4=Icerya_purchasi_4, F_Parasaissetia_nigra_8=Parasaissetia_nigra_8";
		
		//MF
		//mapping=" 7=g, 3=g, 2=b, 1=g, 9=f, 8=g, 5=c, 4=h, 6=e";
		
		
		//MP
		//mapping=" arionides=rubra, Phengaris_atroguttata=arisana, alcon=ruginodis, Phengaris_daitozana=formosae, teleius=rubra, arion=sabuleti, rebeli=schencki, nausithous=rubra";
		
		//PML
		//mapping=" h002-001=h002, h010-001=h010, h017-001=h017, h014-001=h014, h004-001=h004, h003-001=h003, h012-001=h012, h013-001=h013, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h015-001=h015, h006-001=h006, h016-001=h016, h007-001=h007, h011-001=h011, h009-001=h009";
		
		//PMP
		//mapping=" h002-001=h002, h010-001=h010, h017-001=h017, h014-001=h014, h004-001=h004, h003-001=h003, h012-001=h012, h013-001=h013, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h015-001=h015, h006-001=h006, h016-001=h016, h007-001=h007, h011-001=h011, h009-001=h009";
		
		//PP
		//mapping=" h002-001=h002, h008-001=h008, h022-001=h022, h015-001=h015, h031-001=h031, h034-001=h034, h012-001=h012, h026-001=h026, h018-001=h018, h028-001=h028, h016-001=h016, h029-001=h029, h033-001=h033, h030-001=h030, h004-001=h004, h000-001=h000, h024-001=h024, h019-001=h019, h035-001=h035, h014-001=h014, h006-001=h006, h017-001=h017, h025-001=h025, h016-002=h016, h021-001=h021, h003-001=h003, h003-002=h003, h010-001=h010, h011-001=h011, h020-001=h020, h001-001=h001, h018-002=h018, h007-001=h007, h013-001=h013, h005-001=h005, h020-002=h020, h027-001=h027, h032-001=h032, h009-001=h009, h023-001=h023, h008-002=h008";
		
		//RH
		//mapping=" h001-002=h001, h008-001=h008, h021-001=h021, h012-001=h012, h027-001=h027, h030-001=h030, h011-002=h011, h024-002=h024, h015-001=h015, h024-003=h024, h013-001=h013, h025-001=h025, h029-001=h029, h026-001=h026, h003-001=h003, h000-002=h000, h023-001=h023, h017-001=h017, h031-001=h031, h010-003=h010, h005-001=h005, h014-001=h014, h024-004=h024, h013-002=h013, h020-001=h020, h002-001=h002, h032-001=h032, h001-001=h001, h010-001=h010, h010-002=h010, h019-001=h019, h000-001=h000, h016-001=h016, h006-001=h006, h011-001=h011, h004-001=h004, h018-001=h018, h024-001=h024, h028-001=h028, h009-001=h009, h022-001=h022, h007-001=h007";
		
		//RM
		//mapping= " A_cancellosus5=R_ariel_SEBrazil, A_cancellosus6=R_vitellinus, A_cancellosus4=R_sulfuratus, A_cancellosus3=P_inscriptus, A_cancellosus1=R_tucanus";
		
		//RP
		//mapping=" h002-001=h002, h010-001=h010, h004-001=h004, h003-001=h003, h012-001=h012, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h006-001=h006, h007-001=h007, h011-001=h011, h009-001=h009";
		
		//SBL
		//mapping=" Harrisoniella=Buller_Mollymawk, Docophoroides=Buller_Mollymawk, Austrogonoides=Adelie_Penguin, Pectinopygus=Spotted_Shag, Pelmatocerandra=Common_Diving_Petrel, Naubates=Broad-billed_Prion, Episbates=Royal_Albatros, Trabeculus=Mottled_Petrel";
		
		//SC
		//mapping=" h002-001=h002, h006-001=h006, h004-001=h004, h003-001=h003, h010-001=h010, h007-001=h007, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h006-002=h006, h007-002=h007, h004-002=h004, h009-001=h009";
		
		//SFC
		//mapping=" h002-002=h002, h009-001=h009, h013-001=h013, h004-001=h004, h003-001=h003, h011-001=h011, h012-001=h012, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h014-001=h014, h006-001=h006, h007-001=h007, h010-001=h010, h002-001=h002";
		
		//SHA
		//mapping=" BAY=O_palustris, SNV=P_maniculatusG, RIOS=R_megalotis, ORN=O_longicaudatus, BMJ=O_chacoensis, NYV=P_leucopusE, LSC=P_boylii, AND=O_longicaudatus, BCC=S_hispidus, MUL=S_hispidus, BRI=P_leucopusE, EMC=R_mexicanus, PER=A_azarae, MAC=B_obscurus, MON=P_maniculatusF, BRO=P_leucopusSW";
		
		//SSA
		//mapping=" CaSV=C_aethiops, MsSV=M_sphinx, PuSV=P_ursinus, MISV=M_leucophaeus, HsSV=H_sapiens, MmSV=M_mulatta, CpSV=C_patas, PcSV=P_cynocephalus, GgSV=G_gorilla, PtSV=P_troglodytes";
		
		//tahiti_araneae_coleoptera_odonata
		//mapping=" fbpa_araneae_tahiti_sc02275=coi_araneae_tahiti_sc02275, fbpa_araneae_tahiti_sc10278=coi_araneae_tahiti_sc10278, fbpa_araneae_tahiti_sc04248=coi_araneae_tahiti_sc04248, fbpa_araneae_tahiti_sc04291=coi_araneae_tahiti_sc04291, fbpa_odonata_tahiti_sc02835=coi_odonata_tahiti_sc02835, fbpa_coleoptera_tahiti_sc02824=coi_coleoptera_tahiti_sc02824, fbpa_araneae_tahiti_sc02763=coi_araneae_tahiti_sc02763, fbpa_araneae_tahiti_sc10314=coi_araneae_tahiti_sc10314, fbpa_araneae_tahiti_sc02721=coi_araneae_tahiti_sc02721, fbpa_coleoptera_tahiti_sc02826=coi_coleoptera_tahiti_sc02826, fbpa_coleoptera_tahiti_sc02362=coi_coleoptera_tahiti_sc02362, fbpa_araneae_tahiti_sc02148=coi_araneae_tahiti_sc02148";
		
		//TC
		//mapping=" C_irregularis=Myoxocephalus, C_cotunculi=Cottunculus, C_triventricosus=Sebastes, C_yanezi=Neophrinichthys, C_distortus=Cottus, C_tuberculatus=Congiopodus, C_multituberculatus=Dasycottus, C_pinguis=Sebastes, C_nodosus=Sebastes";
		
		//TD
		//mapping=" 3=T_pantostica_hb_Ha, 11=T_artemisiae_Ma, 19=T_swezeyi_Ma, 18=T_denotata_ha_Ma, 15=T_dubautiae_Ma, 5=T_joycei_Ka, 22=T_amoena, 4=T_pantostica_ha_Ha, 20=T_swezeyi_Ka, 13=T_cratericola_Ma, 14=T_beardsleyi_Ma, 6=T_pohakuloa_Ha, 2=T_joycei_Mo, 1=T_joycei_Ma, 9=Ph_newsp_Ka, 16=T_dubautiae_Oa, 7=T_waikamoi_Ma, 17=T_dubautiae_Ka, 8=Ph_vittipennis_Mo, 12=T_arboreae_ha_Ha, 21=T_stellata, 10=T_perkinsi_Ka";
		
		//Wolbacchia
		//mapping=" h155-001=h155, h030-001=h030, h021-001=h021, h033-001=h033, h223-001=h223, h187-001=h187, h175-001=h175, h005-001=h005, h370-001=h370, h023-001=h023, h159-001=h159, h189-001=h189, h185-001=h185, h035-001=h035, h293-001=h293, h333-001=h333, h203-001=h203, h145-001=h145, h234-001=h234, h083-001=h083, h359-001=h359, h314-001=h314, h214-001=h214, h116-001=h116, h055-001=h055, h070-001=h070, h101-001=h101, h207-001=h207, h092-001=h092, h004-001=h004, h082-001=h082, h002-001=h002, h039-001=h039, h303-001=h303, h176-001=h176, h129-001=h129, h199-001=h199, h098-001=h098, h212-001=h212, h286-001=h286, h194-001=h194, h150-001=h150, h160-001=h160, h081-001=h081, h157-001=h157, h258-001=h258, h338-001=h338, h173-001=h173, h182-001=h182, h377-001=h377, h146-001=h146, h042-001=h042, h347-001=h347, h171-001=h171, h275-001=h275, h067-001=h067, h060-001=h060, h131-001=h131, h061-001=h061, h130-001=h130, h149-001=h149, h296-001=h296, h029-001=h029, h016-001=h016, h264-001=h264, h292-001=h292, h163-001=h163, h202-001=h202, h216-001=h216, h013-001=h013, h267-001=h267, h262-001=h262, h294-001=h294, h298-001=h298, h299-001=h299, h139-001=h139, h211-001=h211, h084-001=h084, h279-001=h279, h134-001=h134, h372-001=h372, h087-001=h087, h036-001=h036, h105-001=h105, h366-001=h366, h109-001=h109, h018-001=h018, h040-001=h040, h342-001=h342, h027-001=h027, h219-001=h219, h373-001=h373, h255-001=h255, h301-001=h301, h256-001=h256, h103-001=h103, h075-001=h075, h249-001=h249, h337-001=h337, h106-001=h106, h088-001=h088, h079-001=h079, h010-001=h010, h244-001=h244, h308-001=h308, h025-001=h025, h186-001=h186, h355-001=h355, h114-001=h114, h367-001=h367, h348-001=h348, h351-001=h351, h315-001=h315, h221-001=h221, h290-001=h290, h049-001=h049, h379-001=h379, h019-001=h019, h360-001=h360, h224-001=h224, h321-001=h321, h316-001=h316, h128-001=h128, h069-001=h069, h121-001=h121, h245-001=h245, h037-001=h037, h243-001=h243, h165-001=h165, h277-001=h277, h032-001=h032, h289-001=h289, h271-001=h271, h196-001=h196, h237-001=h237, h151-001=h151, h232-001=h232, h336-001=h336, h077-001=h077, h257-001=h257, h327-001=h327, h218-001=h218, h317-001=h317, h331-001=h331, h090-001=h090, h230-001=h230, h220-001=h220, h385-001=h385, h135-001=h135, h281-001=h281, h006-001=h006, h354-001=h354, h358-001=h358, h302-001=h302, h164-001=h164, h384-001=h384, h095-001=h095, h044-001=h044, h335-001=h335, h188-001=h188, h011-001=h011, h222-001=h222, h168-001=h168, h195-001=h195, h162-001=h162, h263-001=h263, h322-001=h322, h093-001=h093, h052-001=h052, h345-001=h345, h215-001=h215, h269-001=h269, h235-001=h235, h213-001=h213, h154-001=h154, h137-001=h137, h125-001=h125, h038-001=h038, h305-001=h305, h320-001=h320, h172-001=h172, h012-001=h012, h248-001=h248, h217-001=h217, h341-001=h341, h306-001=h306, h246-001=h246, h166-001=h166, h276-001=h276, h177-001=h177, h170-001=h170, h383-001=h383, h107-001=h107, h334-001=h334, h047-001=h047, h078-001=h078, h272-001=h272, h118-001=h118, h065-001=h065, h197-001=h197, h369-001=h369, h045-001=h045, h054-001=h054, h268-001=h268, h026-001=h026, h283-001=h283, h357-001=h357, h247-001=h247, h050-001=h050, h280-001=h280, h319-001=h319, h148-001=h148, h330-001=h330, h382-001=h382, h266-001=h266, h086-001=h086, h041-001=h041, h062-001=h062, h240-001=h240, h140-001=h140, h378-001=h378, h371-001=h371, h270-001=h270, h380-001=h380, h156-001=h156, h046-001=h046, h097-001=h097, h250-001=h250, h158-001=h158, h053-001=h053, h124-001=h124, h034-001=h034, h190-001=h190, h117-001=h117, h353-001=h353, h181-001=h181, h309-001=h309, h318-001=h318, h346-001=h346, h126-001=h126, h056-001=h056, h310-001=h310, h206-001=h206, h239-001=h239, h297-001=h297, h000-001=h000, h260-001=h260, h108-001=h108, h142-001=h142, h375-001=h375, h376-001=h376, h350-001=h350, h074-001=h074, h143-001=h143, h178-001=h178, h231-001=h231, h204-001=h204, h123-001=h123, h080-001=h080, h236-001=h236, h068-001=h068, h138-001=h138, h073-001=h073, h104-001=h104, h008-001=h008, h252-001=h252, h374-001=h374, h208-001=h208, h094-001=h094, h102-001=h102, h144-001=h144, h282-001=h282, h191-001=h191, h233-001=h233, h122-001=h122, h324-001=h324, h363-001=h363, h048-001=h048, h167-001=h167, h332-001=h332, h089-001=h089, h344-001=h344, h076-001=h076, h071-001=h071, h228-001=h228, h085-001=h085, h287-001=h287, h022-001=h022, h127-001=h127, h057-001=h057, h340-001=h340, h064-001=h064, h063-001=h063, h311-001=h311, h323-001=h323, h111-001=h111, h153-001=h153, h147-001=h147, h261-001=h261, h051-001=h051, h381-001=h381, h386-001=h386, h329-001=h329, h119-001=h119, h343-001=h343, h136-001=h136, h356-001=h356, h339-001=h339, h115-001=h115, h100-001=h100, h184-001=h184, h015-001=h015, h072-001=h072, h169-001=h169, h259-001=h259, h017-001=h017, h201-001=h201, h161-001=h161, h291-001=h291, h066-001=h066, h031-001=h031, h229-001=h229, h120-001=h120, h028-001=h028, h007-001=h007, h043-001=h043, h226-001=h226, h141-001=h141, h174-001=h174, h110-001=h110, h024-001=h024, h209-001=h209, h210-001=h210, h312-001=h312, h001-001=h001, h285-001=h285, h295-001=h295, h152-001=h152, h132-001=h132, h349-001=h349, h225-001=h225, h133-001=h133, h304-001=h304, h313-001=h313, h180-001=h180, h365-001=h365, h328-001=h328, h112-001=h112, h242-001=h242, h368-001=h368, h251-001=h251, h192-001=h192, h099-001=h099, h091-001=h091, h361-001=h361, h364-001=h364, h273-001=h273, h253-001=h253, h307-001=h307, h326-001=h326, h193-001=h193, h238-001=h238, h300-001=h300, h113-001=h113, h096-001=h096, h278-001=h278, h200-001=h200, h265-001=h265, h284-001=h284, h183-001=h183, h352-001=h352, h009-001=h009, h205-001=h205, h014-001=h014, h179-001=h179, h288-001=h288, h020-001=h020, h058-001=h058, h227-001=h227, h241-001=h241, h198-001=h198, h274-001=h274, h059-001=h059, h003-001=h003, h325-001=h325, h254-001=h254, h362-001=h362";
		
		
		
		HashMap<String, String> map= new HashMap<>();
		
		String[] commaSplit= mapping.split(",");
		for (String commaEntry: commaSplit) {
			String[] equalSplit= commaEntry.split("=");
			map.put(equalSplit[0].substring(1), equalSplit[1]);
		}
		return map;
	}

	@Override
	public String getUnrootedG() {

		return "(A0,(B0,((F0,E0)!P5,(D0,C0)!P8)!P4)!P2)!P0";
		
		//return "((((L0,(I0,(M0,((E0,F0),(H0,G0))))),(C0,D0)),A0),B0)";
		
		//return "((((L0,((I0,N0),(M0,((E0,F0),(H0,G0))))),(C0,D0)),A0),B0)";
				
	}
	
	@Override
	public boolean hasNext() {
		
		return false;
	}

	
}
